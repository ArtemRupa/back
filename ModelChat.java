import com.sun.xml.internal.ws.resources.SenderMessages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class ModelChat {

    JButton buttonSend;
    JButton buttonSettings;
    boolean SendMessage=false;
    boolean NEW_SYSTEM_MESSAGE=false;


    private JTextField InputMessageField;
    private ViewChatPanel ChatPanel;
    private JScrollPane ScrollChat;
    private String CountMan="";
    private String ChatList="";
    private String SYSTEM_MESSAGE;

    //Самый крупный класс. Отвечает за обработку сообщений и создание панели. Осуществляет логику непосредственно чата.
    //Класс работает с системными и обычными сообщениям.



    //SET

    public synchronized void SetChatList(Scanner ChatList) {
        String FinishedChatList="";
        int count=0;

        while(ChatList.hasNextLine()){
            FinishedChatList = FinishedChatList + "\n" + ChatList.nextLine();
            count++;
        }
        count=count-1;
        this.CountMan=Integer.toString(count);
        this.ChatList=FinishedChatList;
    }

    public void SET_NEW_SYSTEM_MESSAGE(EnumSystemMessage SystemMessage){

        switch(SystemMessage){
            case EXIT_FROM_CHAT: {
                SYSTEM_MESSAGE = "EXIT_FROM_CHAT";
                break;
            }

            case GET_CHAT_LIST: {
                SYSTEM_MESSAGE = "GET_CHAT_LIST";
                break;
            }
        }
        NEW_SYSTEM_MESSAGE=true;

    }


    //GET

    public String GetMessage(){             //Возвращает текст сообщения без ника
        String message = "";

        Scanner scr = new Scanner(InputMessageField.getText());
        while(scr.hasNextLine()){
            message=message+scr.nextLine();
        }

        return message;
    }

    public String GetNick(String Message) {
        Scanner scr= new Scanner(Message);
        String Nick=scr.nextLine();
        return Nick;
    }

    public String GetInputMessage(String Message){
        String message = "";
        Scanner scr = new Scanner(Message);
        scr.nextLine();
        while(scr.hasNextLine()){
            message=message+scr.nextLine();
        }

        return message;
    }

    public synchronized String GetCountMan(){
        return this.CountMan;
    }

    public synchronized String GetChatList(){
        return this.ChatList;
    }

    public String GET_SYSTEM_MESSAGE(){
        return SYSTEM_MESSAGE;
    }


    //Метод обеспечивает сортировку сообщений на входящие и исходящие с помощью enum команд.
    //Отправляет их на отрисовку;

    public synchronized void ChatPanelResources(String nickname, String Message, EnumCommand Command) {

        switch(Command){
            case OUTPUT: ChatPanel.NewUserMessage(Message, nickname); break;
            case INPUT: ChatPanel.NewInputMessage(Message, nickname); break;
        }

        JScrollPane ScrollChat2=ChatPanel.GetScrollPanel();
        ChatPanel.remove(ScrollChat);
        ScrollChat=ScrollChat2;
        ChatPanel.add(ScrollChat);
        ScrollChat.getVerticalScrollBar()
                .setValue(ScrollChat.getVerticalScrollBar().getMaximum());
        ScrollChat.revalidate();
        ChatPanel.revalidate();


    }


    public ModelChat(ViewChatPanel ChatPanel){

        //Создание шапки и добавление на нее элементов//
        SET_NEW_SYSTEM_MESSAGE(EnumSystemMessage.GET_CHAT_LIST);

        ViewHeader HeaderObject = new ViewHeader();
        JButton buttonSettings=HeaderObject.GetButtonSettings();
        JTextArea ChatName=HeaderObject.GetChatNameField(ServerConnection.ChatName);


        //Добавление элементов на общий JPANEL//

        JButton buttonSend = ChatPanel.ButtonSendMessage();
        JTextField InputMessageField = ChatPanel.InputMessageField();
        JScrollPane ScrollChat = ChatPanel.GetScrollPanel();



        ChatPanel.add(ScrollChat);
        ChatPanel.add(buttonSend);
        ChatPanel.add(InputMessageField);
        ChatPanel.add(buttonSettings);
        ChatPanel.add(ChatName);



        this.InputMessageField=InputMessageField;
        this.buttonSend=buttonSend;
        this.ChatPanel=ChatPanel;
        this.ScrollChat=ScrollChat;
        this.buttonSettings=buttonSettings;
    }
}


