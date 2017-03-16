package bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import bot.config.Properties;
import bot.entity.User;
import bot.model.enums.EnumStateType;
import bot.model.messagecallbeck.MessengerCallback;

import bot.model.requestAudio.SendAudio;
import bot.model.requestmenu.MainMenu;
import bot.model.requestmessage.BotMessage;
import bot.model.requestquickreplies.BotQuickReplies;

@Service
public class HandlerService {
	@Autowired
	private Properties prop;

	public void makeQuick(BotQuickReplies q) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(q.toString());
		restTemplate.postForObject(prop.getMessage("message.graph") + prop.getMessage("message.access_token"), q,
				String.class);
	}

	public void makeMessage(BotMessage q) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(prop.getMessage("message.graph") + prop.getMessage("message.access_token"), q,
				String.class);
	}

	public User getNewUser(MessengerCallback messengerCallback) {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("https://graph.facebook.com/v2.6/" + messengerCallback.SenderId()
				+ "?fields=first_name,last_name,gender&access_token=" + prop.getMessage("message.access_token") + "",
				User.class);
		user.setChatState(EnumStateType.BEGIN);
		user.setChatId(messengerCallback.SenderId());
		return user;

	}

	public void makeMenu(MainMenu createMenu) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(prop.getMessage("message.graph") + prop.getMessage("message.access_token"),
				createMenu, String.class);
	}

	public void makeAudio(SendAudio createAudio) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(prop.getMessage("message.graph") + prop.getMessage("message.access_token"),
				createAudio, String.class);
	}
}
