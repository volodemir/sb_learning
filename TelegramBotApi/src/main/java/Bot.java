
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

// Аннотация @Component необходима, чтобы наш класс распознавался Spring, как полноправный Bean
@Component
// Наследуемся от TelegramLongPollingBot - абстрактного класса Telegram API
public class Bot extends TelegramLongPollingBot {

    // Аннотация @Value позволяет задавать значение полю путем считывания из application.yaml
    @Value("${bot.name}")
    private String username;

    @Value("${bot.token}")
    private String token;

    /* Перегружаем метод интерфейса LongPollingBot
        Теперь при получении сообщения наш бот будет отвечать сообщением Hi!
         */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            //String message = update.getMessage().getText().trim();
            String message = "Hi";
            String chatId = update.getMessage().getChatId().toString();

            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(message);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                //todo add logging to the project.
                e.printStackTrace();
            }
        }
    }
    // Геттеры, которые необходимы для наследования от TelegramLongPollingBot

    public String getBotUsername() {
        return username;
    }

    public String getBotToken() {
        return token;
    }
}
