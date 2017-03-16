package bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "SELECT chat_id FROM user where chat_id= ?1", nativeQuery = true)
	Long findUserByChatId(Long chatId);
	
	@Query(value = "SELECT * FROM user where chat_id= ?1", nativeQuery = true)
	User findUser(Long chatId);
}
