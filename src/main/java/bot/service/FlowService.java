package bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bot.component.ConversationComponent;
import bot.config.Properties;
import bot.entity.User;
import bot.entity.UserPet;
import bot.model.enums.EnumFirsPetOwner;
import bot.model.enums.EnumPetType;
import bot.model.enums.EnumStateType;
import bot.model.messagecallbeck.MessengerCallback;

@Service
public class FlowService {
	@Autowired
	private HandlerService handler;
	@Autowired
	private ConversationComponent conversationService;
	@Autowired
	private UserService userService;
	@Autowired
	private PetService petService;
	@Autowired
	private Properties properties;

	public void firsFlow(MessengerCallback messengerCallback, User user) {
		if (messengerCallback.getPostback() != null) {
			if (messengerCallback.getPlay().equals(properties.getMessage("message.get_started"))) {
				hiMessageCatOrDog(messengerCallback, user);
				return;
			}
		}
		switch (user.getChatState()) {
		case SECOND:
			petOwner(messengerCallback, user);
			return;
		case THIRD:
			petNameMessage(messengerCallback, user);
			return;
		case FOURTH:
			petAgeMessage(messengerCallback, user);
			return;
		case FIFTH:
			petAgeSet(messengerCallback, user);
		case EIGHT:
			menuSend(messengerCallback, user);
			return;
		case SIXTH:
			audioOrFeed(messengerCallback, user);
			return;
		case SEVEN:
			sendMay(messengerCallback, user);
			return;
		case NINE:
			callbackIfOneOrDouble(messengerCallback, user);
			return;
		}
	}

	public User createIfNotExist(MessengerCallback messengerCallback) {
		if (userService.findAll().isEmpty()) {
			return createNewUser(messengerCallback);
		} else {
			if (userService.findUserByChatId(messengerCallback.SenderId()) != null) {
				return userService.findUser(messengerCallback.SenderId());
			} else {
				return createNewUser(messengerCallback);
			}
		}
	}

	private User createNewUser(MessengerCallback messengerCallback) {
		User user = handler.getNewUser(messengerCallback);
		UserPet pet = new UserPet();
		pet.setUser(user);
		userService.save(user);
		petService.save(pet);
		return user;
	}

	private void hiMessageCatOrDog(MessengerCallback messengerCallback, User user) {
		conversationService.sendQuickCatDog("Hi " + user.getFirst_name() + properties.getMessage("message.welcome"),
				messengerCallback.getSender());
		UserPet userPet = petService.findPetByUserId(user.getId());
		userPet.setPetType(EnumPetType.CAT);
		user.setChatState(EnumStateType.SECOND);
		petService.update(userPet);
		userService.update(user);

	}

	private void petOwner(MessengerCallback messengerCallback, User user) {
		if (messengerCallback.getBeckType() == null) {
			hiMessageCatOrDog(messengerCallback, user);
			return;
		}
		conversationService.sendQuickYesNo(properties.getMessage("message.owner"), messengerCallback.getSender());
		user.setChatState(EnumStateType.THIRD);
		userService.update(user);
	}

	private void petNameMessage(MessengerCallback messengerCallback, User user) {
		if (messengerCallback.getBeckType() == null) {
			petOwner(messengerCallback, user);
			return;
		}
		if (messengerCallback.getMessageText().equals("Yes")) {
			user.setFirstPet(EnumFirsPetOwner.YES);
		} else {
			user.setFirstPet(EnumFirsPetOwner.NO);
		}
		conversationService.sendMessage(properties.getMessage("message.name"), messengerCallback.getSender());
		user.setChatState(EnumStateType.FOURTH);
		userService.update(user);
	}

	private void petAgeMessage(MessengerCallback messengerCallback, User user) {
		UserPet userPet = petService.findPetByUserId(user.getId());
		userPet.setName(messengerCallback.getMessageText());
		petService.update(userPet);
		conversationService.sendMessage("How old is " + userPet.getName() + "?", messengerCallback.getSender());
		user.setChatState(EnumStateType.FIFTH);
		userService.update(user);
	}

	private void petAgeSet(MessengerCallback messengerCallback, User user) {
		UserPet userPet = petService.findPetByUserId(user.getId());
		userPet.setAge(messengerCallback.getMessageText());
		petService.update(userPet);
		user.setChatState(EnumStateType.EIGHT);
		userService.update(user);
	}

	private void audioOrFeed(MessengerCallback messengerCallback, User user) {
		if (messengerCallback.getPostback() != null) {

			if (messengerCallback.getPlay().equals("audio")) {

				conversationService.sendMessage(properties.getMessage("message.select_audio"),
						messengerCallback.getSender());
				user.setChatState(EnumStateType.SEVEN);
				userService.update(user);

			} else {
				if (messengerCallback.getPlay().equals("feed")) {

					conversationService.sendQuickOneDouble(properties.getMessage("message.select_portion"),
							messengerCallback.getSender());
					user.setChatState(EnumStateType.NINE);
					userService.update(user);
				}
			}
		}
	}

	private void sendMay(MessengerCallback messengerCallback, User user) {
		conversationService.sendAudio(messengerCallback.getSender());
		user.setChatState(EnumStateType.SIXTH);
		userService.update(user);
	}

	private void menuSend(MessengerCallback messengerCallback, User user) {
		conversationService.sendMenu(messengerCallback.getSender());
		user.setChatState(EnumStateType.SIXTH);
		userService.update(user);
	}

	private void callbackIfOneOrDouble(MessengerCallback messengerCallback, User user) {
		if (messengerCallback.getBeckType() == null) {
			menuSend(messengerCallback, user);
			return;
		}
		if (messengerCallback.getMessageText().equals("One portion")) {
			conversationService.sendMessage("thank you \uD83D\uDE0A", messengerCallback.getSender());
		} else {
			conversationService.sendMessage("wow \uD83D\uDE04", messengerCallback.getSender());
		}
		user.setChatState(EnumStateType.SIXTH);
		userService.update(user);
	}

}
