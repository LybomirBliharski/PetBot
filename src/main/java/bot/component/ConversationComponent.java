package bot.component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConversationComponent {

	@Autowired
	private QuickRepliesComponent quickRepliesService;
	@Autowired
	private MenuComponent menuService;
	@Autowired
	private AudioComponent audio;
	@Autowired
	private MessageComponent messageComponent;

	public void sendMenu(Map<String, Long> recipient) {
		menuService.sendMenu(recipient);
	}

	public void sendAudio(Map<String, Long> recipient) {
		audio.sendAudio(recipient);
	}

	public void sendMessage(String message, Map<String, Long> recipient) {

		messageComponent.sendMessage(message, recipient);
	}

	public void sendQuickCatDog(String message, Map<String, Long> recipient) {

		quickRepliesService.sendQuickrepliesCatDog(message, recipient);
	}

	public void sendQuickYesNo(String message, Map<String, Long> recipient) {

		quickRepliesService.sendQuickrepliesYesNo(message, recipient);
	}

	public void sendQuickOneDouble(String message, Map<String, Long> recipient) {

		quickRepliesService.sendQuickrepliesOneDouble(message, recipient);
	}

}
