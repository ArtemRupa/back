import java.awt.event.ActionListener;

//Контроллер для чата

public class ControllerChat {
    private ModelChat modelChat;

    public ControllerChat(ModelChat modelChat){

        modelChat.buttonSend.addActionListener(new ButtonSendActionListener());
        modelChat.buttonSettings.addActionListener(new ButtonSettingsActionListener());

        this.modelChat=modelChat;
    }

    private class ButtonSendActionListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {

            modelChat.SendMessage=true;

        }
    }
    private class ButtonSettingsActionListener implements ActionListener{
        int count=0;
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            if(count==0) {
                ModelLogic.OpenSettingsChat();
            } else {
                modelChat.SET_NEW_SYSTEM_MESSAGE(EnumSystemMessage.GET_CHAT_LIST);
                ModelLogic.OpenSettingsChat();
            }
            count++;
        }
    }


}
