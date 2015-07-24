package main.com.FriendHub.dao;

import java.util.List;

import main.com.FriendHub.Utilities.GroupedMessageNotifications;
import main.com.FriendHub.model.MessageNotifications;

public interface MessageNotificationsDao {
    public void addMessageNotification(MessageNotifications notification);
    public List<GroupedMessageNotifications> getRecentMessageNotifications(int userID);
    public void deleteNotifications(int friend, int userID);
}
