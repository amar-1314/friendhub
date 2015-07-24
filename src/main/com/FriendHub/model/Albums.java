package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "albums")
public class Albums {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int album_ID;
	
	@Column(name = "USER_ID", nullable = false)
	private int userID;

	public int getAlbum_ID() {
		return album_ID;
	}

	public void setAlbum_ID(int album_ID) {
		this.album_ID = album_ID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
}
