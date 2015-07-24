package main.com.FriendHub.service;


import java.util.List;

import main.com.FriendHub.Utilities.GroupedMessageNotifications;
import main.com.FriendHub.model.MessageNotifications;

public interface MessageNotificationsService {
    public List<GroupedMessageNotifications> getRecentMessageNotifications(int userID);
    public void addMessageNotification(MessageNotifications notification);
    public void deleteNotifications(int friend, int userID);
}
