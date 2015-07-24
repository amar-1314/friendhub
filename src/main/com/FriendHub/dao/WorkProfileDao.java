package main.com.FriendHub.dao;
import java.util.List;

import main.com.FriendHub.model.User;
import main.com.FriendHub.model.WorkProfile;

public interface WorkProfileDao {
	
    List<WorkProfile> findAllWorkProfiles(User user);
    String addWorkDetails(WorkProfile workprofile);
    
}
