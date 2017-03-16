package bot.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import bot.entity.User;
import bot.service.UserService;

@Component
public class SchedulComponent {
	@Autowired
	private UserService userService;
	@Autowired
	private ConversationComponent conversationService;
/*
	@Scheduled(fixedDelay = 60000)
	public void feedMeNotification() {
		List<User> list = userService.findAll();
		for (User u : list) {
			Map<String, Long> recipient = new HashMap<String, Long>();
			recipient.put("id", u.getChatId());
			conversationService.communicateWithRecipient("feed me \uD83C\uDF57", recipient);
		}
	}

	@Scheduled(fixedDelay = 70000)
	public void playWithMeNotification() {
		List<User> list = userService.findAll();
		for (User u : list) {
			Map<String, Long> recipient = new HashMap<String, Long>();
			recipient.put("id", u.getChatId());
			conversationService.communicateWithRecipient("play with me \uD83C\uDFAE", recipient);
		}
	}*/

}
