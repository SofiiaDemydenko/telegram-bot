
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class StartCommand extends TelegramLongPollingBot {
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
        update.getUpdateId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.enableHtml(true);
        try {
            sendMessage.setText("<b>Please choose the appropriate option:</b>" +
                    "\n\n/rus - the newest Tech articles from 'Habr' \n         - in Russian" +
                    "\n/eng - the latest Technology news and Startups from 'TechCrunch' \n         - in English");
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
