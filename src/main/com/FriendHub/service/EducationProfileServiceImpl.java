package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.dao.EducationProfileDao;
import main.com.FriendHub.model.EducationProfile;
import main.com.FriendHub.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("educationProfileService")
@Transactional
public class EducationProfileServiceImpl implements EducationProfileService{
		 
	    @Autowired
	    private EducationProfileDao dao;
	     
	   
	    public List<EducationProfile> findAllEducationProfiles(User user) {
	        return dao.findAllEducationProfiles(user);
	    }
	    
	    public String addEducationDetails(EducationProfile educationProfile){
			return dao.addEducationDetails(educationProfile);
			
			
		}

}
