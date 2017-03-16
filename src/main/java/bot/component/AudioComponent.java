package bot.component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bot.config.Properties;
import bot.model.requestAudio.Attachment;
import bot.model.requestAudio.Message;
import bot.model.requestAudio.Payload;
import bot.model.requestAudio.SendAudio;
import bot.service.HandlerService;

@Component
public class AudioComponent {
	@Autowired
	private HandlerService handler;
	@Autowired
	private Properties prop;
	public void sendAudio(Map<String, Long> recipient) {
		SendAudio createAudio = createAudio(recipient);
		handler.makeAudio(createAudio);
	}

	public SendAudio createAudio(Map<String, Long> recipient) {
		SendAudio audio = new SendAudio();
		Message message = new Message();
		Attachment attachment = new Attachment();
		Payload payload = new Payload();

		payload.setUrl(prop.getMessage("message.audio"));
		attachment.setType("audio");
		attachment.setPayload(payload);

		message.setAttachment(attachment);

		audio.setMessage(message);
		audio.setRecipient(recipient);
		return audio;
	}
}
