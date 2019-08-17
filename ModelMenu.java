import javax.swing.*;

public class ModelMenu{

    JButton buttonCreateNewChat;
    JButton buttonJoin;
    JButton buttonExit;

    //Модель главного меню. Содержит только кнопки и панель.

    public ModelMenu(ViewPanel windowMenu){

        JButton createNewChat = windowMenu.GetButtonCreateNewChat();
        JButton buttonJoin = windowMenu.GetButtonJoin();
        JButton buttonExit = windowMenu.GetButtonExit();

        windowMenu.add(createNewChat);
        windowMenu.add(buttonJoin );
        windowMenu.add(buttonExit);

        this.buttonCreateNewChat=createNewChat;
        this.buttonExit=buttonExit;
        this.buttonJoin=buttonJoin;

    }

}
