package bot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bot.model.enums.EnumFirsPetOwner;
import bot.model.enums.EnumStateType;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(mappedBy = "user")
	private UserPet userPet;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "chat_id")
	private Long chat;

	@Column(name = "chat_state")
	private EnumStateType chatState;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "first_pet")
	private EnumFirsPetOwner firstPet;

	public String getLast_name() {
		return last_name;
	}

	public int getId() {
		return id;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Long getChatId() {
		return chat;
	}

	public void setChatId(Long chat) {
		this.chat = chat;
	}

	public String getGender() {
		return gender;
	}

	public EnumStateType getChatState() {
		return chatState;
	}

	public void setChatState(EnumStateType chatState) {
		this.chatState = chatState;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserPet getUserPet() {
		return userPet;
	}

	public void setUserPet(UserPet userPet) {
		this.userPet = userPet;
	}

	public EnumFirsPetOwner getFirstPet() {
		return firstPet;
	}

	public void setFirstPet(EnumFirsPetOwner firstPet) {
		this.firstPet = firstPet;
	}

}
