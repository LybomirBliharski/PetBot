package bot.model.requestquickreplies;

import java.util.Map;

public class BotQuickReplies {
	private Map<String, Long> recipient;
	private QuickRepliesMessage message;

	public QuickRepliesMessage getMessage() {
		return message;
	}

	public void setMessage(QuickRepliesMessage message) {
		this.message = message;
	}

	public Map<String, Long> getRecipient() {
		return recipient;
	}

	public void setRecipient(Map<String, Long> recipient) {
		this.recipient = recipient;
	}

}
