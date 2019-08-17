import javax.swing.*;
import java.util.Scanner;
import java.util.Set;

public class ModelSettings {
    JButton buttonExit;
    JButton buttonBack;

    //Модель настроек, доступ к которым осуществляется из чата

    public ModelSettings(ViewSettings SettingsPanel, ModelChat modelChat){


        String ListChatMan = modelChat.GetChatList();
        String CountUsersInChat = modelChat.GetCountMan();


        JScrollPane ListMan = SettingsPanel.GetChatManPanel(ListChatMan);
        JTextArea CountMan = SettingsPanel.GetCountManPanel(CountUsersInChat);
        JButton buttonExit = SettingsPanel.GetButtonExitChat();
        JButton buttonBack = SettingsPanel.GetButtonBack();


        SettingsPanel.add(buttonExit);
        SettingsPanel.add(buttonBack);
        SettingsPanel.add(ListMan);
        SettingsPanel.add(CountMan);


        this.buttonExit=buttonExit;
        this.buttonBack=buttonBack;
    }

}
