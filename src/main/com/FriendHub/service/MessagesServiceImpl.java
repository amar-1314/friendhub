package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.dao.MessagesDao;
import main.com.FriendHub.model.Messages;
import main.com.FriendHub.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("messagesService")
@Transactional(propagation= Propagation.SUPPORTS)
public class MessagesServiceImpl implements MessagesService{

    @Autowired
    private MessagesDao messagesDao;

    public Messages getMessage(Long messageId) {
        return messagesDao.getMessage(messageId);
    }

    public List<Messages> getRecentMessages(User userID, User friendID) {
        List<Messages> list = messagesDao.getRecentMessages(userID, friendID);
        return list;
    }

    public void addMessage(Messages message) {
        messagesDao.addMessage(message);
    }

}
