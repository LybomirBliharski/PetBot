package bot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("bot/config/messenger.properties")
public class Properties {
	@Autowired
	private Environment env;

	
	public String getMessage(String messageKay) {
		String message = env.getProperty(messageKay);
		return message;
	}
}
