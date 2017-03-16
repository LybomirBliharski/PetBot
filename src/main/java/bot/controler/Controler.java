package bot.controler;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import bot.service.FlowService;
import bot.config.Properties;
import bot.entity.User;
import bot.model.messagecallbeck.MessengerCallback;

@Controller
public class Controler {

	@Autowired
	private FlowService flow;
	@Autowired
	private Properties properties;

	@RequestMapping(value = "/webhook", method = RequestMethod.GET)
	@ResponseBody
	private String verify(@RequestParam(name = "hub.mode") final String hubMode,
			@RequestParam(name = "hub.challenge") final String hubChallenge,
			@RequestParam(name = "hub.verify_token") final String hubToken) {
		if (hubToken.equals(properties.getMessage("message.verify_token"))) {

			return hubChallenge;
		} else {

			return "error";
		}
	}

	@RequestMapping("/webhook/laser")
	public String laser() {
		return "laserFrame";
	}

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	private void receive(@RequestBody MessengerCallback messengerCallback) {
		User user = flow.createIfNotExist(messengerCallback);
		flow.firsFlow(messengerCallback, user);

	}
}
