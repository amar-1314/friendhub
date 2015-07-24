package main.com.FriendHub.service;


import java.util.List;

import main.com.FriendHub.model.Messages;
import main.com.FriendHub.model.User;

public interface MessagesService {
    public Messages getMessage(Long messageId);
    public List<Messages> getRecentMessages(User userID, User friendID);
    public void addMessage(Messages message);
}
