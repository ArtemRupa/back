
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class ViewPanel extends JPanel {

    private Font f = new Font("Roboto", Font.BOLD, 20);
    private Font LabelFont1 = new Font("Comic Sans MS", Font.BOLD, 75);
    private Font LabelFont2 = new Font("Roboto", Font.BOLD, 15);
    private Color buttonColor = View.ColorCustomWhite;
    private Color buttonTextColor = View.buttonTextColor;

    public JButton GetButtonCreateNewChat() {
        JButton buttonCreateNewChat = new JButton("Создать чат");
        buttonCreateNewChat.setBounds(150, 260, 200, 50);
        buttonCreateNewChat.setBackground(buttonColor);
        buttonCreateNewChat.setForeground(buttonTextColor);
        buttonCreateNewChat.setFont(f);
        return buttonCreateNewChat;
    }

    public JLabel HostLabel() {
        JLabel HostLabel = new JLabel("Имя хоста:");
        HostLabel.setFont(LabelFont2);
        HostLabel.setBounds(100, 200, 300, 20);
        HostLabel.setForeground(View.ColorCustomWhite);
        return  HostLabel;
    }

    public JLabel PortLabel() {
        JLabel PortLabel = new JLabel("Номер порта:");
        PortLabel.setFont(LabelFont2);
        PortLabel.setBounds(100, 260, 300, 20);
        PortLabel.setForeground(View.ColorCustomWhite);
        return PortLabel;
    }

    public JLabel NicknameLabel() {
        JLabel NicknameLabel = new JLabel("Никнейм:");
        NicknameLabel.setFont(LabelFont2);
        NicknameLabel.setBounds(100, 320, 300, 20);
        NicknameLabel.setForeground(View.ColorCustomWhite);
        return NicknameLabel;
    }

    public JLabel ChatLabel() {
        JLabel NicknameLabel = new JLabel("Название чата:");
        NicknameLabel.setFont(LabelFont2);
        NicknameLabel.setBounds(100, 380, 300, 20);
        NicknameLabel.setForeground(View.ColorCustomWhite);
        return NicknameLabel;
    }

    public JButton GetButtonCreate() {
        JButton buttonJoin = new JButton("Создать");
        buttonJoin.setBounds(150, 460, 200, 50);
        buttonJoin.setBackground(buttonColor);
        buttonJoin.setForeground(buttonTextColor);
        buttonJoin.setFont(f);
        return buttonJoin;
    }

    public JButton GetButtonJoin() {
        JButton buttonJoin = new JButton("Присоединиться");
        buttonJoin.setBounds(150, 340, 200, 50);
        buttonJoin.setBackground(buttonColor);
        buttonJoin.setForeground(buttonTextColor);
        buttonJoin.setFont(f);
        return buttonJoin;
    }

    public JButton GetButtonExit() {
        JButton buttonExit = new JButton("Выйти");
        buttonExit.setBounds(150, 420, 200, 50);
        buttonExit.setBackground(buttonColor);
        buttonExit.setForeground(buttonTextColor);
        buttonExit.setFont(f);
        return buttonExit;
    }

    public JButton GetButtonBack() {
        JButton buttonBack = new JButton("Назад");
        buttonBack.setBounds(150, 540, 200, 50);
        buttonBack.setBackground(buttonColor);
        buttonBack.setForeground(buttonTextColor);
        buttonBack.setFont(f);
        return buttonBack;
    }

    public JButton GetButtonOK() {
        JButton buttonOK = new JButton("OK");
        buttonOK.setBounds(150, 460, 200, 50);
        buttonOK.setBackground(buttonColor);
        buttonOK.setForeground(buttonTextColor);
        buttonOK.setFont(f);
        return buttonOK;
    }

    public JTextField ServerNum(){
        JTextField ServerNum = new JTextField();
        ServerNum.setBounds(100, 220, 300, 30);
        ServerNum.setBackground(Color.WHITE);
        ServerNum.setForeground(Color.GRAY);
        ServerNum.setFont(f);
        return ServerNum;
    }


    public JFormattedTextField PortNum(){
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField ServerNum = new JFormattedTextField(formatter);
        ServerNum.setBounds(100, 280, 300, 30);
        ServerNum.setBackground(Color.WHITE);
        ServerNum.setForeground(Color.GRAY);
        ServerNum.setFont(f);
        return ServerNum;
    }

    public JTextField Nickname(){
        JTextField ServerNum = new JTextField();
        ServerNum.setBounds(100, 340, 300, 30);
        ServerNum.setBackground(Color.WHITE);
        ServerNum.setForeground(Color.GRAY);
        ServerNum.setFont(f);
        return ServerNum;
    }

    public JTextField ChatName(){
        JTextField ServerNum = new JTextField();
        ServerNum.setBounds(100, 400, 300, 30);
        ServerNum.setBackground(Color.WHITE);
        ServerNum.setForeground(Color.GRAY);
        ServerNum.setFont(f);
        return ServerNum;
    }


    public ViewPanel(){
        setLayout(null);
        setBackground(View.ColorCustomBlue);

        JLabel labelChatGo = new JLabel("ChatGo");
        labelChatGo.setBounds(115, 20, 270, 200);
        labelChatGo.setFont(LabelFont1);
        labelChatGo.setForeground(View.ColorCustomWhite);

        JLabel developerName = new JLabel("Rupa A., 2019");
        developerName.setFont(LabelFont2);
        developerName.setBounds(200, 700, 100, 50);
        developerName.setForeground(View.ColorCustomWhite);


        add(labelChatGo);
        add(developerName);
    }
}

