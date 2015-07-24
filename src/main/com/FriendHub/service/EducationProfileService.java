package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.model.EducationProfile;
import main.com.FriendHub.model.User;


 
public interface EducationProfileService {
 
    List<EducationProfile> findAllEducationProfiles(User user); 
    String addEducationDetails(EducationProfile educationprofile);
}