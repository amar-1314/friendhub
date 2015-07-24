package main.com.FriendHub.dao;

import java.util.List;

import main.com.FriendHub.model.Messages;
import main.com.FriendHub.model.User;

public interface MessagesDao {
    public Messages getMessage(Long messageId);
    public void addMessage(Messages message);
    public List<Messages> getRecentMessages(User userID, User friendID);
}
