package main.com.FriendHub.service;
import java.util.List;

import main.com.FriendHub.dao.WorkProfileDao;
import main.com.FriendHub.model.User;
import main.com.FriendHub.model.WorkProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
 
 
@Service("workProfileService")
@Transactional
public class WorkProfileServiceImpl implements WorkProfileService{
		 
	    @Autowired
	    private WorkProfileDao dao;
	     
	   
	    public List<WorkProfile> findAllWorkProfiles(User user) {
	        return dao.findAllWorkProfiles(user);
	    }
	    
	    public String addWorkDetails(WorkProfile workProfile){
			return dao.addWorkDetails(workProfile);
			
			
		}

		@Override
		public String getWorkProfilByID() {
			// TODO Auto-generated method stub
			return null;
		}
}
