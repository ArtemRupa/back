import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

//Основной класс для работы с сервером. В конструкторе создается сокет, далее в методе CreateSocket
//осуществляется общение с сервером. В этом методе после отработки команды создается новый объект этого же класса.
//Так как важен только последний объект этого класса, его мы записываем в специальную статическую переменную.
//После чего передаем эту статическую переменную непосредственно в логику чата, где он работает с объектом, указание
//на который хранится в этой переменной.


//К объекту этого класса обращается менеджер потоков. ChatThreadManager анализирует данные на панели с помощью ModelChat
//Затем отправляет данные сюда чтоы отправить сообщения.

public class ServerConnection {
    static ServerConnection ActiveServer;
    static String ChatName;
    String ServerName;
    String Nickname;
    Socket socket;
    DataOutputStream out;
    DataInputStream in;
    int Port;
    boolean isConnect=false;

    private void Close() throws IOException{
        in.close();
        socket.close();
    }

    public void SendNewSystemMessage(String SYSTEM_COMMAND) throws IOException{
        if(SYSTEM_COMMAND.equals(EnumSystemMessage.EXIT_FROM_CHAT.toString())){
            Close();
            ChatThreadManager.closeThread();
        }
        out.writeUTF(Nickname+"\n"+"SYSTEM_COMMAND:\n" +SYSTEM_COMMAND);
        out.flush();

    }

    public void SendNewMessage(String Message) throws IOException {
            out.writeUTF(Nickname+"\n"+Message);
            out.flush();
    }

    public String InputNewMessage() throws IOException {
        String Message;
        Message = in.readUTF();
        return Message;
    }

    private void CreateSocket(EnumConnectionCommand Command) throws IOException{
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(ServerName, Port), 200);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        switch (Command) {
            case CONNECT_TO_CHAT: {
                out.writeUTF("CONNECT_TO_CHAT\n"+ChatName+"\n"+Nickname);
                out.flush();
                String answer = in.readUTF();
                int Port = GetNewPortOutAnswer(answer);
                if(Port!=0) {
                    ActiveServer = new ServerConnection(ServerName, Port, Nickname,
                            ChatName, EnumConnectionCommand.CALL_CHAT);
                }
                break;
            }
            case CREATE_CHAT:{
                out.writeUTF("CREATE_CHAT\n"+ChatName+"\n"+Nickname);
                out.flush();
                String answer = in.readUTF();
                int Port = GetNewPortOutAnswer(answer);
                ActiveServer = new ServerConnection(ServerName, Port, Nickname,
                        ChatName, EnumConnectionCommand.CALL_CHAT);
                break;
            }

            case CALL_CHAT: {
                out.writeUTF(Nickname);
                out.flush();
                this.socket = socket;
                this.out = out;
                this.in = in;
                ActiveServer=this;
                isConnect=true;
                break;
            }
        }
    }

    private int GetNewPortOutAnswer(String answer){
        int Port=0;

        Scanner scr = new Scanner(answer);
        String HasChat = scr.nextLine();
        if(HasChat.equals("TRUE")){
            String getPort = scr.nextLine();
            Port = Integer.parseInt(getPort);
        } else {
            ExceptionHandler.SetException(HasChat);
            System.out.print("Подключение невозможно");
            isConnect=false;
            ActiveServer=this;
        }

        return Port;
    }

    public ServerConnection(String ServerName, int Port, String Nickname, String ChatName, EnumConnectionCommand Command) {
        this.ChatName=ChatName;
        this.Nickname=Nickname;
        this.ServerName=ServerName;
        this.Port=Port;
        this.ChatName=ChatName;
        try{ CreateSocket(Command); } catch (IOException e){}

    }

}

