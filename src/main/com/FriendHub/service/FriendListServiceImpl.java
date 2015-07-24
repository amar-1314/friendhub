package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.dao.FriendListDao;
import main.com.FriendHub.model.FriendList;
import main.com.FriendHub.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
@Service("friendlistservice")
@Transactional
public class FriendListServiceImpl implements FriendListService{
 
    @Autowired
    private FriendListDao dao;
     
    public List<FriendList> getFriendList(User ID) {
        return dao.getFriendList(ID);
     
    } 
    public int getFriendCount(User ID) {
    return dao.getFriendCount(ID);
    }
    
    public List<FriendList>  getFriendListByCategory(User userID,Integer categoryID)  {
        return dao.getFriendListByCategory(userID, categoryID);
     
    } 
    public void addFriend(FriendList friend) {

    	dao.addFriend(friend);
	}
    public List<User> checkFriends(User userID, User friendID)
    {
    	return dao.checkFriends(userID,friendID);
    }
    public void unfriend(User friend) {

    	dao.unfriend(friend);
	}

}

