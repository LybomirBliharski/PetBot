package bot.model.newthred;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewThread {
	@JsonProperty("setting_type")
	private String settingType;
	@JsonProperty("thread_state")
	private String threadState;
	@JsonProperty("call_to_actions")
	private List<CallToActions> callToActions;

	public List<CallToActions> getCallToActions() {
		return callToActions;
	}

	public void setCallToActions(List<CallToActions> callToActions) {
		this.callToActions = callToActions;
	}

	public String getSettingType() {
		return settingType;
	}

	public void setSettingType(String settingType) {
		this.settingType = settingType;
	}

	public String getThreadState() {
		return threadState;
	}

	public void setThreadState(String threadState) {
		this.threadState = threadState;
	}

}
