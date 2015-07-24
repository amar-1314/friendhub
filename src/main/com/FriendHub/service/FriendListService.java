package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.model.FriendList;
import main.com.FriendHub.model.User;
public interface FriendListService {
 
    List<FriendList> getFriendList(User ID);
    int getFriendCount(User Uid);
    List<FriendList>  getFriendListByCategory(User userID,Integer categoryID);
    void addFriend(FriendList friend);
    public List<User> checkFriends(User userID, User friendID);
    void unfriend(User friend);
}

