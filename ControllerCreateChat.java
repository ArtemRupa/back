import java.awt.event.ActionListener;

//Контроллер для меню создания чата

public class ControllerCreateChat {

    ModelCreateChat modelCreateChat;
    ControllerCreateChat(ModelCreateChat modelCreateChat){

        modelCreateChat.buttonBack.addActionListener(new ControllerCreateChat.ButtonBackActionListener());
        modelCreateChat.buttonOK.addActionListener(new ControllerCreateChat.ButtonJoinActionListener());
        this.modelCreateChat=modelCreateChat;
    }

    private class ButtonJoinActionListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e)  {
            try {
                modelCreateChat.ConnectionServer();
            } catch (Exception end){System.out.println("Введены не все данные");}
        }
    }
    private class ButtonBackActionListener implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            ModelLogic.OpenMenu(EnumViewLogicCommand.VisibleCreateNewChatPanelFalse);
        }
    }
}

