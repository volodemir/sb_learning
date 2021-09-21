import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Аннотация, которая объединяет в себя @Configuration, @EnableAutoConfiguration, @ComponentScan
@SpringBootApplication
public class TelegramLongPollingBotApp {
    public static void main(String[] args) {
        SpringApplication.run(Bot.class, args);
    }
}
