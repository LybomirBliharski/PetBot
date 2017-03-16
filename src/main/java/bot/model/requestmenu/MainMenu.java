package bot.model.requestmenu;

import java.util.Map;

public class MainMenu {
	private Map<String, Long> recipient;
	private MenuMessage message;

	public Map<String, Long> getRecipient() {
		return recipient;
	}

	public void setRecipient(Map<String, Long> recipient) {
		this.recipient = recipient;
	}

	public MenuMessage getMessage() {
		return message;
	}

	public void setMessage(MenuMessage message) {
		this.message = message;
	}
}
