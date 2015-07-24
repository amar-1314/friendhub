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
@Table(name = "message_notifications")
public class MessageNotifications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "SENDER_ID", nullable = false)
	private User senderID;

	@Column(name = "RECEIVER_ID", nullable = false)
	private int receiverID;

	@Column(name = "TIMESTAMP")
	private Timestamp timeStamp;
	
	public MessageNotifications(User senderID, int receiverID, Timestamp date) {
		this.senderID = senderID;
		this.receiverID = receiverID;
		this.timeStamp = date;
	}

	public MessageNotifications() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

}
