import javax.swing.*;

public class ModelCreateChat {

    JButton buttonBack;
    JButton buttonOK;
    private JTextField TextFieldServerNum;
    private JFormattedTextField TextFieldPortNum;
    private JTextField TextFieldNickname;
    private JTextField TextFieldChatName;
    private ViewPanel modelCreateChat;

    //Модель создания чата. Схожа с моделью Авторизации. Создана, чтобы избежать лишней путаницы.

    public void ConnectionServer() {
        int PortNum = (int) TextFieldPortNum.getValue();
        if(TextFieldServerNum!=null && TextFieldPortNum!=null && TextFieldNickname!=null) {
            try {
                String ServerName = TextFieldServerNum.getText();
                new ServerConnection(ServerName, PortNum,
                        TextFieldNickname.getText(), TextFieldChatName.getText(),
                        EnumConnectionCommand.CREATE_CHAT);
                try{
                    if(ServerConnection.ActiveServer.isConnect==true) {
                        ModelLogic.OpenChat(ServerConnection.ActiveServer,
                                EnumViewLogicCommand.VisibleCreateNewChatPanelFalse);
                    } else {
                        ExceptionHandler.ExceptionHandler(modelCreateChat);
                    }
                } catch (Exception e){
                    ExceptionHandler.ExceptionHandler(modelCreateChat);
                }

            } catch (Exception e){e.printStackTrace(); ExceptionHandler.ExceptionHandler(modelCreateChat);}
        }
    }


    public ModelCreateChat(ViewPanel modelCreateChat){
        JButton buttonBack = modelCreateChat.GetButtonBack();
        JButton buttonOK = modelCreateChat.GetButtonCreate();
        JTextField TextFieldServerNum = modelCreateChat.ServerNum();
        JFormattedTextField TextFieldPortNum = modelCreateChat.PortNum();
        JTextField TextFieldNickname = modelCreateChat.Nickname();
        JTextField ChatName = modelCreateChat.ChatName();
        JLabel HostLabel = modelCreateChat.HostLabel();
        JLabel PortLabel = modelCreateChat.PortLabel();
        JLabel NicknameLabel = modelCreateChat.NicknameLabel();
        JLabel ChatNameLabel = modelCreateChat.ChatLabel();


        modelCreateChat.add(buttonBack);
        modelCreateChat.add(buttonOK);
        modelCreateChat.add(TextFieldServerNum);
        modelCreateChat.add(TextFieldPortNum);
        modelCreateChat.add(TextFieldNickname);
        modelCreateChat.add(HostLabel);
        modelCreateChat.add(PortLabel);
        modelCreateChat.add(NicknameLabel);
        modelCreateChat.add(ChatNameLabel);
        modelCreateChat.add(ChatName);

        this.modelCreateChat=modelCreateChat;
        this.TextFieldChatName=ChatName;
        this.buttonBack=buttonBack;
        this.buttonOK=buttonOK;
        this.TextFieldServerNum=TextFieldServerNum;
        this.TextFieldPortNum=TextFieldPortNum;
        this.TextFieldNickname=TextFieldNickname;
    }
}
