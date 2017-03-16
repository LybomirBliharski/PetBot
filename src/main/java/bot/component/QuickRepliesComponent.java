package bot.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bot.model.requestquickreplies.BotQuickReplies;
import bot.model.requestquickreplies.QuickReplies;
import bot.model.requestquickreplies.QuickRepliesMessage;
import bot.service.HandlerService;

@Service
public class QuickRepliesComponent {
	@Autowired
	private HandlerService handler;

	public void sendQuickrepliesCatDog(String message, Map<String, Long> recipient) {
		BotQuickReplies quick = makeQuickrepliesCatDog(message, recipient);
		handler.makeQuick(quick);
	}

	public void sendQuickrepliesYesNo(String message, Map<String, Long> recipient) {
		BotQuickReplies quick = makeQuickrepliesYesNo(message, recipient);
		handler.makeQuick(quick);
	}
	public void sendQuickrepliesOneDouble(String message, Map<String, Long> recipient) {
		BotQuickReplies quick = makeQuickrepliesOneDouble(message, recipient);
		handler.makeQuick(quick);
	}

	private BotQuickReplies makeQuickrepliesCatDog(String message, Map<String, Long> recipient) {
		BotQuickReplies bot = new BotQuickReplies();

		QuickRepliesMessage mesage = new QuickRepliesMessage();

		List<QuickReplies> quickReplies = new ArrayList<QuickReplies>();

		quickReplies.add(createQuick("Cat", "go to cat"));
		quickReplies.add(createQuick("Dog", "go to dog"));

		mesage.setText(message);
		mesage.setQuickReplies(quickReplies);

		bot.setMessage(mesage);
		bot.setRecipient(recipient);
		return bot;
	}

	private BotQuickReplies makeQuickrepliesYesNo(String message, Map<String, Long> recipient) {
		BotQuickReplies bot = new BotQuickReplies();

		QuickRepliesMessage mesage = new QuickRepliesMessage();

		List<QuickReplies> quickReplies = new ArrayList<QuickReplies>();

		quickReplies.add(createQuick("Yes", "go to yes"));
		quickReplies.add(createQuick("No", "go to no"));

		mesage.setText(message);
		mesage.setQuickReplies(quickReplies);

		bot.setMessage(mesage);
		bot.setRecipient(recipient);
		return bot;
	}
	private BotQuickReplies makeQuickrepliesOneDouble(String message, Map<String, Long> recipient) {
		BotQuickReplies bot = new BotQuickReplies();

		QuickRepliesMessage mesage = new QuickRepliesMessage();

		List<QuickReplies> quickReplies = new ArrayList<QuickReplies>();

		quickReplies.add(createQuick("One portion", "one"));
		quickReplies.add(createQuick("Double portion", "double"));

		mesage.setText(message);
		mesage.setQuickReplies(quickReplies);

		bot.setMessage(mesage);
		bot.setRecipient(recipient);
		return bot;
	}

	private QuickReplies createQuick(String title, String payload) {
		QuickReplies quickReplies = new QuickReplies();
		quickReplies.setContentType("text");
		quickReplies.setTitle(title);
		quickReplies.setPayload(payload);
		return quickReplies;
	}
}
