package bot.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bot.config.Properties;
import bot.model.requestmenu.Attachment;
import bot.model.requestmenu.Button;
import bot.model.requestmenu.Elements;
import bot.model.requestmenu.MainMenu;
import bot.model.requestmenu.MenuMessage;
import bot.model.requestmenu.Payload;
import bot.service.HandlerService;

@Component
public class MenuComponent {
	@Autowired
	private HandlerService handler;
	@Autowired
	private Properties prop;

	public void sendMenu(Map<String, Long> recipient) {
		MainMenu createMenu = createMenu(recipient);
		handler.makeMenu(createMenu);
	}

	public MainMenu createMenu(Map<String, Long> recipient) {

		MainMenu menu = new MainMenu();

		MenuMessage message = new MenuMessage();

		Attachment attachment = new Attachment();

		Payload payload = new Payload();

		List<Elements> elements = new ArrayList<Elements>();

		List<Button> buttonsOne = new ArrayList<>();
		List<Button> buttonsTwo = new ArrayList<>();

		buttonsOne.add(setButtonsUrl("Play with laser", prop.getMessage("message.webviev")));
		buttonsOne.add(setButtonsPostback("Talk to your pet", "audio"));
		buttonsOne.add(setButtonsPostback("Feed your pet", "feed"));
		buttonsTwo.add(setButtonsPostback("Learn more", "about"));
		buttonsTwo.add(setButtonsUrl("View Website about Diet recommendations ",prop.getMessage("message.pet_url")));

		elements.add(
				setElements(buttonsOne, prop.getMessage("message.menu_title"), prop.getMessage("message.first_img")));
		elements.add(setElements(buttonsTwo, "select action",prop.getMessage("message.second_img")));

		payload.setElements(elements);
		payload.setTemplateType("generic");

		attachment.setType("template");
		attachment.setPayload(payload);

		message.setAttachment(attachment);

		menu.setMessage(message);
		menu.setRecipient(recipient);
		return menu;
	}

	public Button setButtonsPostback(String title, String postbek) {
		Button buttons = new Button();
		buttons.setPayload(postbek);
		buttons.setTitle(title);
		buttons.setType("postback");
		return buttons;
	}

	public Button setButtonsUrl(String title, String url) {
		Button buttons = new Button();
		buttons.setUrl(url);
		buttons.setTitle(title);
		buttons.setType("web_url");
		return buttons;
	}

	public Elements setElements(List<Button> buttons, String title, String url) {
		Elements element = new Elements();
		element.setButtons(buttons);
		element.setImageUrl(url);
		element.setSubtitle("action");
		element.setTitle(title);
		return element;
	}
}
