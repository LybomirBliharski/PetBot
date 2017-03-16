package bot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bot.entity.UserPet;



@Repository
public interface PetRepository extends JpaRepository<UserPet,Integer>{
	@Query(value = "SELECT * FROM user_pet where user_id= ?1", nativeQuery = true)
	UserPet findAllByUserId(Integer userId);
}
