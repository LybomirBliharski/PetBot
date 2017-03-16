package bot.model.messagecallbeck;

import java.util.Map;

public class Messaging {

	private Map<String, Long> sender;
	private Map<String, Long> recipient;
	private Long timestamp;
	private Postback postback;
	private Message message;

	public Postback getPostback() {
		return postback;
	}

	public void setPostback(Postback postback) {
		this.postback = postback;
	}

	public Messaging() {
	}

	public Map<String, Long> getSender() {
		return sender;
	}

	public Messaging setSender(final Map<String, Long> sender) {
		this.sender = sender;
		return this;
	}

	public Map<String, Long> getRecipient() {
		return recipient;
	}

	public Messaging setRecipient(final Map<String, Long> recipient) {
		this.recipient = recipient;
		return this;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public Messaging setTimestamp(final Long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public Message getMessage() {
		return message;
	}

	public Messaging setMessage(final Message message) {
		this.message = message;
		return this;
	}

}
