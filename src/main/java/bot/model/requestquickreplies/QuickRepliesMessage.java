package bot.model.requestquickreplies;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuickRepliesMessage {

	private String text;
	@JsonProperty("quick_replies")
	private List<QuickReplies> quickReplies;

	public List<QuickReplies> getQuickReplies() {
		return quickReplies;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setQuickReplies(List<QuickReplies> quickReplies) {
		this.quickReplies = quickReplies;
	}
}
