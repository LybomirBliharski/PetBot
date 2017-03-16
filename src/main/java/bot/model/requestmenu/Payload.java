package bot.model.requestmenu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload {
	@JsonProperty("template_type")
	private String templateType;
	private List<Elements> elements;

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public List<Elements> getElements() {
		return elements;
	}

	public void setElements(List<Elements> elements) {
		this.elements = elements;
	}
}
