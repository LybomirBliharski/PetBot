package bot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bot.dao.PetRepository;
import bot.entity.UserPet;

@Service
public class PetService {
	private PetRepository petRepository;
	public PetService(PetRepository petRepository) {

		this.petRepository = petRepository;
	}
	public void save(UserPet pet) {
		petRepository.save(pet);
	}
	@Transactional(readOnly = false)
	public UserPet update(UserPet user) {
		return petRepository.saveAndFlush(user);
	}
	public UserPet findPetByUserId(int userId){
		return petRepository.findAllByUserId(userId);
	}
}
