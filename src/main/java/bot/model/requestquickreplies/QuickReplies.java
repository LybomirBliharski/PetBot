package bot.model.requestquickreplies;


import com.fasterxml.jackson.annotation.JsonProperty;

public class QuickReplies {
	@JsonProperty("content_type")
	String contentType;
	String title;
	String payload;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPayload() {
		return payload;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
