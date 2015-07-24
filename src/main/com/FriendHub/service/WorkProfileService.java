package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.model.User;
import main.com.FriendHub.model.WorkProfile;

 
public interface WorkProfileService {
 
    List<WorkProfile> findAllWorkProfiles(User user); 
    String addWorkDetails(WorkProfile workprofile);
    String getWorkProfilByID();
}