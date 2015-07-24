package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hidden_status")
public class HiddenStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_ID;

	@Column(name = "HIDDEN_USER_ID", nullable = false)
	private int hiddenUserID;

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public int getHiddenUserID() {
		return hiddenUserID;
	}

	public void setHiddenUserID(int hiddenUserID) {
		this.hiddenUserID = hiddenUserID;
	}
}
