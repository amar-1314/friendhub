package main.com.FriendHub.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Messages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "MESSAGE")
	private String message;

	@ManyToOne
	@JoinColumn(name = "SENDER_ID", nullable = false)
	private User senderID;

	
	@Column(name = "RECEIVER_ID", nullable = false)
	private int receiverID;

	@Column(name = "TIMESTAMP")
	private Timestamp timeStamp;
	
	public Messages(String text, User user, int friendID, Timestamp date) {
		this.message = text;
		this.senderID = user;
		this.receiverID = friendID;
		this.timeStamp = date;
	}

	public Messages() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public User getSenderID() {
		return senderID;
	}

	public void setSenderID(User senderID) {
		this.senderID = senderID;
	}

	public int getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

}
