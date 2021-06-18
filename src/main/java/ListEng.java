import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class ListEng extends TelegramLongPollingBot {
    private long chat_id;
    private Document document;

    public ListEng(){
        connect();
    }

    private void connect() {
        try {
            document = Jsoup.connect("https://techcrunch.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void getListEng(){
        String[]info = new String[5];

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chat_id));
        sendMessage.enableHtml(true);

        Elements titles = document.getElementsByClass("post-block__title");
        Elements author = document.getElementsByClass("river-byline__authors");
        Elements link = document.getElementsByClass("post-block__title__link");

        for (int i = 0; i <titles.size(); i++) {

            if(i < 5){
                info[i] = "\n" + "<b>" + titles.get(i).text() + "</b>"
                        + "\n\n<b>Author: </b> " + author.get(i).text()
                        + "\n\n" + link.get(i).attr("href");
                try{
                    sendMessage.setText(info[i]);
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

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
        chat_id = update.getMessage().getChatId();
        getListEng();
    }
}
