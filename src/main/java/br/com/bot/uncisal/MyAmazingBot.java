
package br.com.bot.uncisal;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.api.objects.polls.PollOption;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
    				
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
        	
        	System.out.println(update.getMessage().toString());
        	System.out.println(update.getPoll());
        	Poll poll = new Poll();
        	poll.setQuestion("Quantos anos eu tenho?");
        	List<PollOption> options  = new ArrayList<PollOption>();
        	PollOption opcao = new PollOption();
        	opcao.setText("20");
        	options.add(opcao);
        	opcao.setText("21");
        	options.add(opcao);
        	opcao.setText("22");
        	options.add(opcao);
        	poll.setOptions(options);
        	
        	
        	
        	
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            
            SendMessage message = new SendMessage(); // Create a message object object
          
            	message.setChatId(Long.toString(chat_id));
            		message.setText(message_text);
            		
            		SendPoll send = new SendPoll();
            		send.setChatId(chat_id);
            		List<String> opcoes  = new ArrayList<String>();
            		opcoes.add("21");
            		opcoes.add("22");
            		opcoes.add("23");
            		opcoes.add("24");
            		
            		send.setOptions(opcoes);
            		send.setAllowMultipleAnswers(false);
            		send.setCorrectOptionId(1);
            		send.setQuestion("Quantos anos eu tenho?");
            		send.setExplanation("Explanação");
//                    .setChatId(Long.toString(chat_id))
//                    .setText(message_text);
            try {
                execute(send); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        
        return "@uncisal_agenda_bot";
    }

    @Override
    public String getBotToken() {
      
        return "1548997079:AAEvvNI-cTIDYCl_gDwqiEY7X7az8HFnMng";
    }
}