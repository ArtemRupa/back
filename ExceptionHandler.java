import javax.swing.*;
import java.util.Stack;

public class ExceptionHandler {

    //Обработчик ошибок. Ошибки записываются в стек, после чего категоризируются с помощью Enum-класса с кодами ошибок
    //Создан для категоризации поступщих с сервера ошибок

    private static Stack<EnumExceptionCode> ExceptionStack = new Stack<>();

    public static void ExceptionHandler(ViewPanel panel){
        EnumExceptionCode command;
        if(ExceptionStack.empty()==false) {
             command = ExceptionStack.pop();
        } else{
             command=EnumExceptionCode.DEFAULT;
        }
            switch (command){
                case NICK_IS_BUSY: {
                    ExceptionPanel(panel,
                            "Этот ник занят. Выберите другой");
                    break;
                }
                case THIS_CHAT_ALREADY_CREATED: {
                    ExceptionPanel(panel,
                            "Чат с таким названием уже создан, присоединитесь к нему или создайте длругой");
                    break;
                }
                default:{
                    ExceptionPanel(panel,
                            "Ошибка подключения. Сервер недоступен, либо данные введены неверно");
                    break;}
            }
    }

    private static void ExceptionPanel(ViewPanel panel, String Message){
        JOptionPane.showMessageDialog(panel, Message,
                "Ошибка", JOptionPane.CLOSED_OPTION);
    }

    public static void SetException(String command){
        switch (command){
            case "NICK_IS_BUSY": ExceptionStack.push(EnumExceptionCode.NICK_IS_BUSY); break;
            case "THIS_CHAT_ALREADY_CREATED":ExceptionStack.push(EnumExceptionCode.THIS_CHAT_ALREADY_CREATED); break;
        }
    }
}
