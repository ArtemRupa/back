import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public static Font f = new Font("Roboto", Font.BOLD, 14);
    public static Font Strongf = new Font("Roboto", Font.BOLD, 25);
    public static Color ColorCustomBlue = new Color(70, 130, 180);
    public static Color ColorCustomWhite=new Color(255, 248, 220);
    public static Color buttonTextColor = new Color(0, 51, 102);
    public static Color WhiteBlueChat = new Color(204, 229, 255);

    //Создание JFrame


    public View() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 800);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(ColorCustomBlue);

    }

}
