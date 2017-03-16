package bot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bot.dao.UserRepository;
import bot.entity.User;

@Service
public class UserService {
	private UserRepository userrepository;

	public UserService(UserRepository userrepository) {

		this.userrepository = userrepository;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		for (User user : userrepository.findAll()) {
			list.add(user);
		}
		return list;

	}

	public User findOne(int id) {
		return userrepository.findOne(id);
	}

	public void save(User task) {
		userrepository.save(task);
	}

	@Transactional(readOnly = false)
	public User update(User user) {
		return userrepository.saveAndFlush(user);
	}

	public Long findUserByChatId(long chatId) {
		return userrepository.findUserByChatId(chatId);
	}

	public User findUser(long chatId) {
		return userrepository.findUser(chatId);
	}
}
