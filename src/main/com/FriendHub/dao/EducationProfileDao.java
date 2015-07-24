package main.com.FriendHub.dao;
import java.util.List;

import main.com.FriendHub.model.EducationProfile;
import main.com.FriendHub.model.User;


public interface EducationProfileDao {
	
    List<EducationProfile> findAllEducationProfiles(User user);
    String addEducationDetails(EducationProfile educationprofile);
}
