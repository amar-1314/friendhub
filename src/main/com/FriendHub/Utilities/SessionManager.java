package main.com.FriendHub.Utilities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.com.FriendHub.model.User;

import org.mvel2.optimizers.impl.refl.nodes.ArrayLength;
import org.springframework.context.annotation.Scope;

@Scope("session")
public class SessionManager {
	
	
	private static String sessionID;
	private static User user;
	private static HashMap<String, User> activeUsersData = new HashMap<String, User>();
	

	public static User getUser() {
		return user;
	}
	public static void setUser(User user) {
		SessionManager.user = user;
	}
	
	public static void setSessionAttributes(String sID,User userData) {
		sessionID = sID;
	user = userData;
	activeUsersData.put(sessionID, user);
	}

	public static String getSessionID() {
		return sessionID;
	}
	
	public static User  getCurrentUser(String sID)
	{
		return activeUsersData.get(sID);
	}
	
	public static void removeActiveUser(String sID)
	{
		activeUsersData.remove(sID);
	}
	
	public static List<User> getActiveUsers(String sID)
	{
		List<User> activeUsersList = new ArrayList<User>();
		User currentUser = activeUsersData.get(sID);
		activeUsersData.remove(sID);
		for (User activeUser : activeUsersData.values()) {
			activeUsersList.add(activeUser);
		}
		activeUsersData.put(sID, currentUser);
		return activeUsersList;
	}

}
