package bot.model.messagecallbeck;

import java.util.List;
import java.util.Map;

public class Message {
	private String mid;
	private Long seq;
	private String text;
	private List<Attachments> attachments;
	private Map<String, String> quick_reply;

	public Map<String, String> getQuick_reply() {
		return quick_reply;
	}

	public void setQuick_reply(Map<String, String> quick_reply) {
		this.quick_reply = quick_reply;
	}

	public String getMid() {
		return this.mid;
	}

	public Long getSeq() {
		return this.seq;
	}

	public String getText() {
		return this.text;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Attachments> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}

}