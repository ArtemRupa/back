
import java.awt.event.ActionListener;

//Контроллер для главного меню

public class ControllerMenu {

    ModelMenu ModelMenu;

    public ControllerMenu(ModelMenu Menu){
        Menu.buttonCreateNewChat.addActionListener(new ButtonCreateNewChatActionListener());
        Menu.buttonJoin.addActionListener(new ButtonJoinActionListener());
        Menu.buttonExit.addActionListener(new ButtonExitActionListener());
        this.ModelMenu=Menu;

    }

    private class ButtonCreateNewChatActionListener implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            ModelLogic.OpenCreateChatMenu();
        }
    }
    private class ButtonJoinActionListener implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            ModelLogic.OpenAuthorizationMenu();
        }
    }
    private class ButtonExitActionListener implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            System.exit(0);
        }
    }
}
