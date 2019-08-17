import javax.swing.*;

public class ModelAuthorization {

    //Модель автризации. Далее во всех моделях создается панель с набором элементов. Кнопки не private
    // так как они должны ыть видны контроллеру из другого класса.
    //Здесь осуществаляется подключение к серверу и создание объекта ServerConnection;

    JButton buttonBack;
    JButton buttonOK;
    private JTextField TextFieldServerNum;
    private JFormattedTextField TextFieldPortNum;
    private JTextField TextFieldNickname;
    private JTextField TextFieldChatName;
    private ViewPanel windowAuthorization;

    public void ConnectionServer() {
        int PortNum = (int) TextFieldPortNum.getValue();
        if (TextFieldServerNum != null && TextFieldPortNum != null && TextFieldNickname != null) {
            try {
                String ServerName = TextFieldServerNum.getText();
                new ServerConnection(ServerName, PortNum,
                        TextFieldNickname.getText(), TextFieldChatName.getText(),
                        EnumConnectionCommand.CONNECT_TO_CHAT);
                try {
                    if (ServerConnection.ActiveServer.isConnect == true) {
                        ModelLogic.OpenChat(ServerConnection.ActiveServer,
                                EnumViewLogicCommand.VisibleAuthrizPanelFalse);
                    } else {
                        ExceptionHandler.ExceptionHandler(windowAuthorization);
                    }
                } catch (Exception e) {
                    ExceptionHandler.ExceptionHandler(windowAuthorization);
                }

            } catch (Exception e) {
                ExceptionHandler.ExceptionHandler(windowAuthorization);
            }
        }
    }

    public ModelAuthorization(ViewPanel windowAuthorization) {

        JButton buttonBack = windowAuthorization.GetButtonBack();
        JButton buttonOK = windowAuthorization.GetButtonOK();
        JTextField TextFieldServerNum = windowAuthorization.ServerNum();
        JFormattedTextField TextFieldPortNum = windowAuthorization.PortNum();
        JTextField TextFieldNickname = windowAuthorization.Nickname();
        JTextField TextFieldChatName = windowAuthorization.ChatName();
        JLabel HostLabel = windowAuthorization.HostLabel();
        JLabel PortLabel = windowAuthorization.PortLabel();
        JLabel NicknameLabel = windowAuthorization.NicknameLabel();
        JLabel ChatNameLabel = windowAuthorization.ChatLabel();

        windowAuthorization.add(buttonBack);
        windowAuthorization.add(buttonOK);
        windowAuthorization.add(TextFieldServerNum);
        windowAuthorization.add(TextFieldPortNum);
        windowAuthorization.add(TextFieldNickname);
        windowAuthorization.add(HostLabel);
        windowAuthorization.add(PortLabel);
        windowAuthorization.add(NicknameLabel);
        windowAuthorization.add(TextFieldChatName);
        windowAuthorization.add(ChatNameLabel);

        this.windowAuthorization = windowAuthorization;
        this.buttonBack = buttonBack;
        this.buttonOK = buttonOK;
        this.TextFieldServerNum = TextFieldServerNum;
        this.TextFieldPortNum = TextFieldPortNum;
        this.TextFieldNickname = TextFieldNickname;
        this.TextFieldChatName = TextFieldChatName;
    }
}
