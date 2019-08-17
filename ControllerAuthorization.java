

import java.awt.event.ActionListener;

//Класс контроллер для меню авторизации

public class ControllerAuthorization {
    ModelAuthorization Menu;

        public ControllerAuthorization (ModelAuthorization Menu){

            Menu.buttonBack.addActionListener(new ButtonBackActionListener());
            Menu.buttonOK.addActionListener(new ButtonJoinActionListener());
            this.Menu=Menu;

        }

        private class ButtonJoinActionListener implements ActionListener{
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)  {
                try {
                    Menu.ConnectionServer();
                } catch (Exception end){System.out.println("Введены не все данные");}
            }
        }
        private class ButtonBackActionListener implements ActionListener{

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ModelLogic.OpenMenu(EnumViewLogicCommand.VisibleAuthrizPanelFalse);
            }
        }
}

