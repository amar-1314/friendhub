package main.com.FriendHub.dao;

import java.util.List;

import main.com.FriendHub.model.FriendList;
import main.com.FriendHub.model.User;

public interface FriendListDao {
	  List<FriendList> getFriendList(User ID);
	  int getFriendCount(User Uid);
	List<FriendList> getFriendListByCategory(User userID,Integer categoryID);
	 void addFriend(FriendList friend);
	List<User> checkFriends(User userID, User friendID);
	 void unfriend(User friend);
}

