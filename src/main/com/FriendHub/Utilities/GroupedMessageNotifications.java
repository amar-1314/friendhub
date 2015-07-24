package main.com.FriendHub.Utilities;

import main.com.FriendHub.model.User;

public class GroupedMessageNotifications {
	private User senderID;
	private Long count;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public User getSenderID() {
		return senderID;
	}

	public void setSenderID(User senderID) {
		this.senderID = senderID;
	}


}