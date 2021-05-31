
package br.com.bot.uncisal;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.polls.Poll;
import org.telegram.telegrambots.meta.api.objects.polls.PollOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import br.com.bot.uncisal.model.Alternativa;
import br.com.bot.uncisal.model.Pergunta;

public class MyAmazingBot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {
		
		// We check if the update has a message and the message has text
		if (update.hasMessage() && update.getMessage().hasText()) {
//        	
//			Alternativa[] alternativas = new Alternativa[] { new Alternativa(1, "Bill Gates"),
//					new Alternativa(2, "Steve Jobs"), new Alternativa(3, "Allan turing"),
//					new Alternativa(4, "Linus Torvalds"), new Alternativa(5, "Von Neumann") };
//			Alternativa correta = new Alternativa(4, "Linus Torvalds");
//			Pergunta pergunta = new Pergunta("Quem criou o linux? ", alternativas, correta);
			System.out.println(update.getMessage().getFrom().toString());

			// Set variables
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();

			SendMessage message = new SendMessage(); // Create a message object object
			message.setChatId(Long.toString(chat_id));
			
			
			
			
			
			
			if (message_text.equals("/iniciar")) {
				message.setText(message_text);
				Runnable perguntaRunnable = new Runnable() {
					public void run() {


//						message.setText(pergunta.getPerguntaString());

						executarMensagem(message);
						
					
						try
						{
							message.setText("O tempo da pergunta acabou.");
							Thread.sleep(30000);
							executarMensagem(message);
							
						}
						catch(InterruptedException ex)
						{
							Thread.currentThread().interrupt();
						}
					}
					
				};
				
				ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
				executor.scheduleAtFixedRate(perguntaRunnable, 0, 10, TimeUnit.HOURS);
			
				
				
			}
//			if (message_text.equals("/a")) {
//				if(pergunta.verificarRespostaCorreta(new Alternativa(1))) {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " acertou e ganhou 10 pontos");
//					System.out.println("entrou aq");
//				}
//				else {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " errou");
//				}
//				executarMensagem(message);
//			}
//			if (message_text.equals("/b")) {
//				if(pergunta.verificarRespostaCorreta(new Alternativa(2))) {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " acertou e ganhou 10 pontos");
//				}
//				else {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " errou");
//				}
//				executarMensagem(message);
//			}
//			if (message_text.equals("/c")) {
//				if(pergunta.verificarRespostaCorreta(new Alternativa(3))) {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " acertou e ganhou 10 pontos");
//				}
//				else {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " errou");
//				}
//				executarMensagem(message);
//			}
//			if (message_text.equals("/d")) {
//				if(pergunta.verificarRespostaCorreta(new Alternativa(4))) {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " acertou e ganhou 10 pontos");
//				}
//				else {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " errou");
//				}
//				executarMensagem(message);
//			}
//			if (message_text.equals("/e")) {
//				if(pergunta.verificarRespostaCorreta(new Alternativa(5))) {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " acertou e ganhou 10 pontos"); 
//				}
//				else {
//					message.setText("O(a) @" + update.getMessage().getFrom().getUserName() + " errou");
//				}
//				executarMensagem(message);
//			}
		}
	}

	
	public void executarMensagem(SendMessage message) {
		try {
		
			execute(message);

			
		} catch (TelegramApiException e) {
	
			e.printStackTrace();
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