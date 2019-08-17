
import javax.swing.*;
import java.awt.*;

public class ViewChatPanel extends JPanel {

    private  Font f = View.f;
    private static int YlastMessage;
    JPanel panelMess;

    public JPanel NewUserMessage(String message, String Nickname){
        JPanel messagePanel = new JPanel();
        JTextArea text = new JTextArea(message);
        JTextArea nickname = new JTextArea(Nickname + ":" + "\n");
        messagePanel.setLayout(null);
        messagePanel.setBackground(Color.GREEN);
        nickname.setBounds(5,0,200, 20);
        nickname.setForeground(Color.BLACK);
        nickname.setBackground(Color.GREEN);
        nickname.setFont(f);
        text.setTabSize(10);
        text.setFont(f);

        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setForeground(new Color(255, 248, 220));
        text.setBackground(Color.GREEN);

        int LineCount = countLines(text, 195);
        int sizePanel = LineCount*text.getPreferredSize().height;
        text.setBounds(5,25,195, sizePanel);
        messagePanel.setBounds(270, 10+YlastMessage, 210, sizePanel+25);
        text.setEditable(false);
        nickname.setEditable(false);
        messagePanel.add(nickname);
        messagePanel.add(text);
        panelMess.add(messagePanel);


        YlastMessage=YlastMessage+40+sizePanel;
        panelMess.setPreferredSize(new Dimension(400, YlastMessage));
        panelMess.revalidate();


        return messagePanel;
    }

    public JPanel NewInputMessage(String message, String Nickname){
        JPanel messagePanel = new JPanel();
        JTextArea text = new JTextArea(message);
        JTextArea nickname = new JTextArea(Nickname + ":" + "\n");
        messagePanel.setLayout(null);
        messagePanel.setBackground(Color.gray);
        nickname.setBounds(5,0,200, 20);
        nickname.setForeground(Color.BLACK);
        nickname.setBackground(Color.gray);
        nickname.setFont(f);
        text.setTabSize(10);
        text.setFont(f);

        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setForeground(new Color(255, 248, 220));
        text.setBackground(Color.gray);

        int LineCount = countLines(text, 195);
        int sizePanel = LineCount*text.getPreferredSize().height;
        text.setBounds(5,25,195, sizePanel);
        messagePanel.setBounds(0, 10+YlastMessage, 210, sizePanel+25);
        text.setEditable(false);
        nickname.setEditable(false);

        messagePanel.add(nickname);
        messagePanel.add(text);
        panelMess.add(messagePanel);

        YlastMessage=YlastMessage+40+sizePanel;
        panelMess.setPreferredSize(new Dimension(400, YlastMessage));
        panelMess.revalidate();

        return messagePanel;
    }

    public JTextField InputMessageField(){
        JTextField InputMessageField = new JTextField("Сообщение");
        InputMessageField.setBounds(0, 735, 420, 40);
        InputMessageField.setBackground(Color.WHITE);
        InputMessageField.setForeground(Color.GRAY);
        return InputMessageField;
    }

    public JButton ButtonSendMessage(){
        JButton ButtonSendMessage = new JButton("Send");
        ButtonSendMessage.setBounds(420, 735, 80, 40);
        ButtonSendMessage.setBackground(View.buttonTextColor);
        ButtonSendMessage.setForeground(View.ColorCustomWhite);
        return ButtonSendMessage;
    }


    public JScrollPane GetScrollPanel(){
        panelMess.getPreferredSize();
        JScrollPane PanelChat = new JScrollPane(panelMess);
        PanelChat.setBounds(0,50, 500,685);
        PanelChat.setMaximumSize(new Dimension(500,685));
        PanelChat.setPreferredSize(new Dimension(500,panelMess.getPreferredSize().height));
        PanelChat.setBackground(View.WhiteBlueChat);
        PanelChat.setFont(f);
        PanelChat.getVerticalScrollBar()
                .setValue(PanelChat.getVerticalScrollBar().getMaximum());
        PanelChat.setVisible(true);
        panelMess.setVisible(true);
        return PanelChat;
    }


    private int countLines(JTextArea message, int width) {

        FontMetrics fontMetrics = message.getFontMetrics(message.getFont());
        String text = message.getText();
        String[] tokens = text.split(" ");
        String currentLine = "";
        boolean beginningOfLine = true;
        int noLines = 1;

        for (int i = 0; i < tokens.length; i++) {
            if (beginningOfLine) {
                beginningOfLine = false;
                currentLine = currentLine + tokens[i];
            } else {
                currentLine = currentLine + " " + tokens[i];
            }

            if (fontMetrics.stringWidth(currentLine) > width) {
                currentLine = "";
                beginningOfLine = true;
                noLines++;
            }
        }

        System.out.print("there are " + noLines + "lines" + System.getProperty("line.separator"));
        return noLines+2;
    }

    public ViewChatPanel(){
        setLayout(null);
        setBackground(Color.WHITE);
        setVisible(true);
        JPanel panelMess = new JPanel();
        panelMess.setBackground(View.WhiteBlueChat);
        panelMess.setLayout(null);
        this.panelMess=panelMess;
        this.YlastMessage=0;

    }
}
