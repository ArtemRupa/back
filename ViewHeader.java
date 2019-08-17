import javax.swing.*;
import java.awt.*;

public class ViewHeader extends JPanel{
    JPanel Header;
    private Color ColorCustomWhite = View.ColorCustomWhite;
    private Color TextColor = View.buttonTextColor;


    public JButton GetButtonSettings(){
        JButton ButtonSettings = new JButton();
        ImageIcon icon = new ImageIcon("images/settings.png");
        ButtonSettings.setIcon(icon);
        ButtonSettings.setBounds(0, 0, 100, 50);
        ButtonSettings.setBackground(ColorCustomWhite);
        ButtonSettings.setForeground(Color.GRAY);
        ButtonSettings.setVisible(true);
        return ButtonSettings;
    }


    public JTextArea GetChatNameField(String Name){
        JTextArea ChatName= new JTextArea("   Название чата: "+Name);
        ChatName.setBounds(100, 0, 400, 50);
        ChatName.setBackground(ColorCustomWhite);
        ChatName.setForeground(TextColor);
        ChatName.setFont(View.Strongf);
        ChatName.setVisible(true);
        ChatName.setEditable(false);
        return ChatName;
    }


    public ViewHeader(){
        JPanel Header = new JPanel();

        Header.setBounds(0, 0, 500, 50);
        Header.setBackground(ColorCustomWhite);
        Header.setForeground(TextColor);
        Header.setFont(View.f);
        Header.setLayout(null);

        this.Header=Header;
    }
}
