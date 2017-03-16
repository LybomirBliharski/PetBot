package bot.model.requestAudio;

import java.util.Map;

public class SendAudio {
	private Map<String, Long> recipient;
	private Message message;

	public Map<String, Long> getRecipient() {
		return recipient;
	}

	public void setRecipient(Map<String, Long> recipient) {
		this.recipient = recipient;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
