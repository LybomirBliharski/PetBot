package bot.model.messagecallbeck;

import java.util.List;
import java.util.Map;

public class MessengerCallback {
	private String object;
	private List<Entry> entry;

	public MessengerCallback() {
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public List<Entry> getEntry() {
		return entry;
	}

	public void setEntry(List<Entry> entry) {
		this.entry = entry;
	}

	public Map<String, Long> getSender() {

		return oneMessaging().getSender();

	}

	public Long SenderId() {
		Long senderId = oneMessaging().getSender().get("id");
		return senderId;

	}

	public String getMessageText() {

		return oneMessaging().getMessage().getText();

	}

	public String getPlay() {

		return oneMessaging().getPostback().getPayload();

	}

	public Postback getPostback() {

		return oneMessaging().getPostback();

	}

	public Messaging oneMessaging() {
		List<Entry> entryList = getEntry();

		Entry entry = entryList.get(0);

		List<Messaging> messagingList = entry.getMessaging();

		Messaging messaging = messagingList.get(0);
		return messaging;
	}

	public Map<String, String> getBeckType() {
		return oneMessaging().getMessage().getQuick_reply();

	}

}
