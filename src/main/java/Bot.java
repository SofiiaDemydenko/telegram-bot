import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public class Bot extends TelegramLongPollingBot {
    ListRus listRus = new ListRus();
    StartCommand startCommand = new StartCommand();
    InfoCommand infoCommand = new InfoCommand();
    ListEng listEng = new ListEng();

    @Override
    public String getBotUsername() {
        return "testversionjavabot";
    }

    @Override
    public String getBotToken() {
        return "1846346342:AAGyOGolMJPCpV2rYuYJjT8_-fB-ZQnOsYo";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());
            message.enableHtml(true);
            switch (update.getMessage().getText()) {
                case "/start":
                    startCommand.onUpdateReceived(update);
                    break;
                case "/rus":
                    listRus.onUpdateReceived(update);
                    break;
                case "/eng":
                    listEng.onUpdateReceived(update);
                    break;
                case "/info":
                    infoCommand.onUpdateReceived(update);
                    break;
            }
        }
    }
}

