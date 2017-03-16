package bot.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bot.model.requestmessage.BotMessage;
import bot.service.HandlerService;
@Component
public class MessageComponent {
	@Autowired
	private HandlerService handler;
	public void sendMessage(String text, Map<String, Long> recipient) {
		BotMessage message = makeMessage(text, recipient);
		handler.makeMessage(message);
	}

	private BotMessage makeMessage(String text, Map<String, Long> recipient) {
		BotMessage bot = new BotMessage();
		Map<String, String> messageData = new HashMap<String, String>();
		messageData.put("text", text);
		bot.setMessage(messageData);
		bot.setRecipient(recipient);
		return bot;
	}
}
