

public class ModelLogic {

    private static View window;
    private static ViewPanel MenuPanel;
    private static ViewPanel AuthorizationPanel;
    private static ViewPanel CreateChatMenu;
    private static ViewChatPanel ChatPanel;
    private static ViewSettings SettingsPanel;
    private static ModelChat modelChat;

    //Логика программы. Класс со всеми статичными методами, используется для перехода от одного меню к другому.
    //Объкт этого класса создается единожды при открытии программы
    //Основная задача - обеспечить смену элементов JPanel


    public static void OpenAuthorizationMenu() {
        AuthorizationPanel = new ViewPanel();
        ModelAuthorization ModelAuthorization = new ModelAuthorization(AuthorizationPanel);
        new ControllerAuthorization(ModelAuthorization);
        MenuPanel.setVisible(false);
        window.add(AuthorizationPanel);
        AuthorizationPanel.setVisible(true);
    }

    public static void OpenCreateChatMenu() {
        CreateChatMenu = new ViewPanel();
        ModelCreateChat ModelCreateChat = new ModelCreateChat(CreateChatMenu);
        new ControllerCreateChat(ModelCreateChat);
        MenuPanel.setVisible(false);
        window.add(CreateChatMenu);
        CreateChatMenu.setVisible(true);
    }

    public static void OpenMenu(EnumViewLogicCommand command) {
        ModelMenu Menu = new ModelMenu(MenuPanel);
        new ControllerMenu(Menu);
        switch (command) {
            case VisibleAuthrizPanelFalse:
                AuthorizationPanel.setVisible(false);
                break;
            case VisibleCreateNewChatPanelFalse:
                CreateChatMenu.setVisible(false);
                break;
        }
        window.add(MenuPanel);
        MenuPanel.setVisible(true);
    }

    public static void OpenChat(ServerConnection server, EnumViewLogicCommand command) {
        ChatPanel = new ViewChatPanel();
        modelChat = new ModelChat(ChatPanel);
        new ChatThreadManager(server, modelChat);
        new ControllerChat(modelChat);
        switch (command) {
            case VisibleAuthrizPanelFalse:
                AuthorizationPanel.setVisible(false);
                break;
            case VisibleCreateNewChatPanelFalse:
                CreateChatMenu.setVisible(false);
                break;
        }
        window.add(ChatPanel);
        ChatPanel.setVisible(true);
    }

    public static void OpenSettingsChat() {
        SettingsPanel = new ViewSettings();
        ModelSettings modelSettings = new ModelSettings(SettingsPanel, modelChat);
        new ControllerSettings(modelSettings);
        ChatPanel.setVisible(false);
        window.add(SettingsPanel);
        SettingsPanel.setVisible(true);
    }

    public static void BackToChatFromSettings() {
        SettingsPanel.setVisible(false);
        ChatPanel.setVisible(true);

    }

    public static void ExitFromChat() {
        modelChat.SET_NEW_SYSTEM_MESSAGE(EnumSystemMessage.EXIT_FROM_CHAT);
        ChatPanel.setVisible(false);
        SettingsPanel.setVisible(false);
        MenuPanel.setVisible(true);
    }


    public ModelLogic() {
        View window = new View();
        ViewPanel MenuPanel = new ViewPanel();
        ModelMenu Menu = new ModelMenu(MenuPanel);
        new ControllerMenu(Menu);

        window.add(MenuPanel);


        this.window = window;
        this.MenuPanel = MenuPanel;

    }
}
