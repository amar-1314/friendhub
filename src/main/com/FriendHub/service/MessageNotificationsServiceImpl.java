package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.Utilities.GroupedMessageNotifications;
import main.com.FriendHub.dao.MessageNotificationsDao;
import main.com.FriendHub.model.MessageNotifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("messageNotificationsService")
@Transactional(propagation= Propagation.SUPPORTS)
public class MessageNotificationsServiceImpl implements MessageNotificationsService{

    @Autowired
    private MessageNotificationsDao messageNotificationsDao;

    public List<GroupedMessageNotifications> getRecentMessageNotifications(int userID) {
        List<GroupedMessageNotifications> list = messageNotificationsDao.getRecentMessageNotifications(userID);
        return list;
    }

    public void addMessageNotification(MessageNotifications notification) {
    	messageNotificationsDao.addMessageNotification(notification);
    }

    public void deleteNotifications(int friendID, int userID) {
    	messageNotificationsDao.deleteNotifications(friendID, userID);
    }
}
