package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notifications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notification_ID;

	@Column(name = "NOTIFICATION_TYPE_ID")
	private int notificationTypeID;

	@Column(name = "SENDER_ID")
	private int senderID;
	
	@Column(name = "RECEIVER_ID")
	private int receiverID;

	@Column(name = "READ/UNREAD_FLAG")
	private Byte readFlag;

	public int getNotification_ID() {
		return notification_ID;
	}

	public void setNotification_ID(int notification_ID) {
		this.notification_ID = notification_ID;
	}

	public int getNotificationTypeID() {
		return notificationTypeID;
	}

	public void setNotificationTypeID(int notificationTypeID) {
		this.notificationTypeID = notificationTypeID;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public int getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}

	public Byte getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Byte readFlag) {
		this.readFlag = readFlag;
	}
}
