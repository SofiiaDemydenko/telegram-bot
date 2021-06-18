import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class InfoCommand extends TelegramLongPollingBot {
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
            sendMessage.setText("<b>This bot allows you to check the newest articles and highlights from Tech" +
                    " Websites and Blogs. Namely from 'Habr' and 'TechCrunch'</b>" +
                    "\n/rus - to check Russian-language posts from 'Habr'" +
                    "\n/eng - to check English-language posts from 'TechCrunch'" +
                    "\n\nYou'll be given the 5 newest articles with a little description, rating/author and link" +
                    "\n\n<i>For more info</i>  @sofiia_demydenko :)");
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
