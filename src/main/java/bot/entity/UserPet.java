package bot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bot.model.enums.EnumPetType;


@Entity
@Table(name = "UserPet")
public class UserPet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "pet_name")
	private String name;
	
	@Column(name = "pet_age")
	private String age;
	
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@Column(name = "pet_type")
	private EnumPetType petType;

	@Enumerated(EnumType.STRING)
	public EnumPetType getPetType() {
		return petType;
	}

	public void setPetType(EnumPetType petType) {
		this.petType = petType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAge(String age) {
		this.age = age;
	}


}
