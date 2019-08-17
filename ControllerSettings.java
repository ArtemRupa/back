import java.awt.event.ActionListener;

//Контроллер для меню настроек в чате

public class ControllerSettings {
    ModelSettings modelSettings;

    public ControllerSettings(ModelSettings modelSettings){
        modelSettings.buttonBack.addActionListener(new ButtonBackActionListener());
        modelSettings.buttonExit.addActionListener(new ButtonOutActionListener());
        this.modelSettings=modelSettings;
    }

    private class ButtonOutActionListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            ModelLogic.ExitFromChat();
        }
    }
    private class ButtonBackActionListener implements ActionListener{

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            ModelLogic.BackToChatFromSettings();
        }
    }

}
