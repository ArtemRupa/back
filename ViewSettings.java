import javax.jws.soap.SOAPBinding;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class ViewSettings extends JPanel {

    private Color ColorCustomWhite = View.ColorCustomWhite;
    private Color ColorCustomBlue = View.ColorCustomBlue;
    private Color ButtonColor = View.WhiteBlueChat;
    private Font f = new Font("Roboto", Font.BOLD, 20);


    public JScrollPane GetChatManPanel(String ChatList){
        JTextArea Users = new JTextArea(ChatList);
        Users.setBackground(ColorCustomWhite);
        Users.setFont(f);
        Users.setForeground(Color.BLACK);
        Users.setEditable(false);
        JScrollPane UsersScrollPanel = new JScrollPane(Users);
        UsersScrollPanel.setBounds(50, 100, 400,450);
        UsersScrollPanel.setBackground(ColorCustomWhite);
        UsersScrollPanel.setFont(f);
        JLabel labelNick = new JLabel("Никнейм: Порт");
        Users.add(labelNick);
        labelNick.setFont(f);
        labelNick.setForeground(Color.orange);
        labelNick.setBounds(0,0,300,20);
        UsersScrollPanel.setVisible(true);
        return UsersScrollPanel;
    }

    public JButton GetButtonExitChat(){
        JButton ButtonExitChat = new JButton("Выйти из беседы");
        ButtonExitChat.setBounds(125, 700, 250, 50);
        ButtonExitChat.setBackground(ButtonColor);
        ButtonExitChat.setForeground(Color.RED);
        ButtonExitChat.setVisible(true);
        ButtonExitChat.setFont(f);
        return ButtonExitChat;
    }

    public JButton GetButtonBack(){
        JButton ButtonBack = new JButton("Назад");
        ButtonBack.setBounds(125, 600, 250, 50);
        ButtonBack.setBackground(ButtonColor);
        ButtonBack.setForeground(Color.BLACK);
        ButtonBack.setVisible(true);
        ButtonBack.setFont(f);
        return ButtonBack;
    }

    public JTextArea GetCountManPanel(String CountUserInChat){

        JTextArea Users = new JTextArea(CountUserInChat);
        Users.setBackground(ColorCustomBlue);
        Users.setFont(f);
        Users.setForeground(Color.orange);
        Users.setBounds(350,28,50,40);
        Users.setEditable(false);

        return Users;
    }


    public ViewSettings(){
        setLayout(null);
        JLabel label = new JLabel("Число участников чата: ");
        label.setFont(f);
        label.setForeground(ColorCustomWhite);
        label.setBounds(100,20,250,40);
        JLabel CountMan = new JLabel("Список участников");
        CountMan.setFont(f);
        CountMan.setBounds(150,50,200,50);
        CountMan.setForeground(ColorCustomWhite);
        add(label);
        add(CountMan);
        setBackground(ColorCustomBlue);
        setForeground(ColorCustomWhite);
        setFont(f);
    }
}
