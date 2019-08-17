

import java.io.IOException;
import java.util.Scanner;

//Чат для работы с потоками во время диалога. Есть входящий и исходящий потоки, в run исходящего потока
// присутствует вызов обработчика системных команд, чтобы обрабатывать служебные команды, поступающие с сервера
// Создание объекта этого класса приводит к созданию двух этих потоков

public class ChatThreadManager {
    private static ThreadInputListener InputsThread;

    public static void closeThread() {
        InputsThread.interrupt();
    }


    public ChatThreadManager(ServerConnection server, ModelChat Chat) {

        this.InputsThread = new ThreadInputListener(server, Chat);
        InputsThread.start();
        ThreadSender OutputThread = new ThreadSender(server, Chat);
        OutputThread.start();
    }
}


class ThreadInputListener extends Thread {

    ServerConnection server;
    ModelChat Chat;

    private boolean SystemCommandHandler(String message) {
        Scanner scr = new Scanner(message);
        String CommandCheck = scr.nextLine();

        if (CommandCheck.equals("SYSTEM_COMMAND:")) {
            String Command = scr.nextLine();

            switch (Command) {

                case "GET_CHAT_LIST": {
                    Chat.SetChatList(scr);
                    break;
                }

                case "GET_COUNT_USERS": {

                    break;
                }
            }

            return true;
        } else {
            return false;
        }
    }


    @Override
    public void run() {
        while (!server.socket.isClosed()) {
            String NewMessage;
            try {
                NewMessage = server.InputNewMessage();
                if (NewMessage != null && SystemCommandHandler(NewMessage) == false) {

                    String nickname = Chat.GetNick(NewMessage);
                    String Message = Chat.GetInputMessage(NewMessage);
                    if (server.Nickname.equals(nickname)) {
                        Chat.ChatPanelResources(server.Nickname, Message, EnumCommand.OUTPUT);
                    } else {
                        Chat.ChatPanelResources(nickname, Message, EnumCommand.INPUT);
                    }

                } else {
                    Thread.yield();
                }
            } catch (Exception e) {
                System.out.print("Вы вышли из чата, входящий поток закрыт\n");
                break;
            }
        }

    }

    public ThreadInputListener(ServerConnection server, ModelChat Chat) {
        this.server = server;
        this.Chat = Chat;
    }
}


class ThreadSender extends Thread {
    ServerConnection server;
    ModelChat Chat;

    @Override
    public void run() {
        try {
            while (!server.socket.isClosed()) {
                if (Chat.SendMessage == true) {
                    String Message = Chat.GetMessage();
                    Chat.SendMessage = false;
                    server.SendNewMessage(Message);
                } else {
                    if (Chat.NEW_SYSTEM_MESSAGE == true) {
                        server.SendNewSystemMessage(Chat.GET_SYSTEM_MESSAGE());
                        Chat.NEW_SYSTEM_MESSAGE = false;
                    }
                }
                Thread.yield();
            }
        } catch (IOException e) {
            System.out.print("Вы вышли из чата, исходящий поток закрыт\n");
        }
        this.interrupt();

    }

    public ThreadSender(ServerConnection server, ModelChat Chat) {
        this.server = server;
        this.Chat = Chat;
    }
}
