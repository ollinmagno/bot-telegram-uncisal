package br.com.bot.uncisal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class UncisalApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(UncisalApplication.class, args);
		ApiContextInitializer.init();
        // Instantiate Telegram Bots API
//        TelegramBotsApi botsApi = new TelegramBotsApi(null);
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new MyAmazingBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        
        
   
	}
      

}
