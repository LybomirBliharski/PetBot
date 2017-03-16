package bot.model.requestmessage;

import java.util.Map;

public class BotMessage {
	private Map<String, Long> recipient;
	private Map<String, String> message;

	public Map<String, Long> getRecipient() {
		return recipient;
	}

	public Map<String, String> getMessage() {
		return message;
	}

	public void setRecipient(Map<String, Long> recipient) {
		this.recipient = recipient;
	}

	public void setMessage(Map<String, String> message) {
		this.message = message;
	}

}
