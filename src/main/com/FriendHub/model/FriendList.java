package main.com.FriendHub.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "friend_list")
@SuppressWarnings("serial")
public class FriendList implements Serializable {
	/*
	@EmbeddedId
	private FriendListKeys friendListKeys;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int unique_ID;
	
	@ManyToOne
	@JoinColumn(name = "User_ID")
	    private User userID;
	
	@ManyToOne
	@JoinColumn(name = "FRIEND_USER_ID")
	private User friendUserID;
	
	@Column(name = "REQUEST_STATUS")
	private char requestStatus;
	
	@Column(name = "CATEGORY_ID")
	private int categoryID;
	
	
	public int getUnique_ID() {
		return unique_ID;
	}
	public void setUnique_ID(int unique_ID) {
		this.unique_ID = unique_ID;
	}
	public User getUserID() {
		return userID;
	}
	public void setUserID(User userID) {
		this.userID = userID;
	}
	public User getFriendUserID() {
		return friendUserID;
	}
	public void setFriendUserID(User friendUserID) {
		this.friendUserID = friendUserID;
	}
	@Column(name = "")
	/*public FriendListKeys getFriendListKeys() {
		return friendListKeys;
	}
	public void setFriendListKeys(FriendListKeys friendListKeys) {
		this.friendListKeys = friendListKeys;
	}*/
	public char getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(char requestStatus) {
		this.requestStatus = requestStatus;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
}
