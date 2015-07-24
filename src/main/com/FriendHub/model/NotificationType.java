package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification_type")
public class NotificationType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notification_Type_ID;

	@Column(name = "NOTIFICATION_NAME")
	private String notificationName;

	public int getNotification_Type_ID() {
		return notification_Type_ID;
	}

	public void setNotification_Type_ID(int notification_Type_ID) {
		this.notification_Type_ID = notification_Type_ID;
	}

	public String getNotificationName() {
		return notificationName;
	}

	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}
}
