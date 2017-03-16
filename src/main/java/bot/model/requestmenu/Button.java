package bot.model.requestmenu;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Button {
	private String type;
	private String title;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String url;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String payload;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
}
