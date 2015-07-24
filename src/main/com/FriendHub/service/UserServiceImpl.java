package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.dao.UserDao;
import main.com.FriendHub.model.PrivacySettings;
import main.com.FriendHub.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
 
 
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
 
    @Autowired
    private UserDao dao;
     
    public void saveUser(User user) {
        dao.saveUser(user);
    }
 
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }
 
    public void deleteUserByEmail(String email) {
        dao.deleteUserByEmail(email);
    }
    
    public String getUserByEmail(String email) {
        return dao.getUserByEmail(email);
    } 
    
    public User getUserByID(int id){
    	return dao.getUserByID(id);
    }
    public void registerUser(User user){
    	dao.registerUser(user);
    }

    public String getSecQuesByEmail(String email){
    	System.out.println("in service");
    	return dao.getSecQuesByEmail(email);
    }
    
    public String getSecQuesByName(String fname,String lname){
    	return dao.getSecQuesByName(fname,lname);
    }
    
	@Override
	public User getUserByEmailID(String email) {
		return dao.getUserByEmailID(email);
	}
    
	public void saveUserProfile(User user){
		 dao.saveUserProfile(user);
	}
	public String getSecAnsByEmail(String emailID){
		return dao.getSecAnsByEmail(emailID);
    }
	
	public String getEmailByName(String fname, String lname){
		return dao.getEmailByName(fname,lname);
	}
	public String deactivateUserWithEmail(String emailID){
		return dao.deactivateUserWithEmail(emailID);
	}
    public String updateSecQuesAnsWithEmail(String secQues, String secAns, String emailID){
    	return dao.updateSecQuesAnsWithEmail(secQues,secAns,emailID);
    }
    public String deleteUserWithEmail(String emailID){
    	return dao.deleteUserWithEmail(emailID);
    }
    public String updateTwoFactorWithEmail(String emailID){
    	return dao.updateTwoFactorWithEmail(emailID);
    }
    public String disableTwoFactorWithEmail(String emailID){
    	return dao.updateTwoFactorWithEmail(emailID);
    }
    public String updatePassword(String encodedPwd, String emailID){
    	return dao.updatePassword(encodedPwd,emailID);
    }
    
	public void saveProfilePicture(User user,MultipartFile file){
		 dao.saveProfilePicture(user,file);
	}
	
    public User getNameByEmailID(String email){
    	return  dao.getNameByEmailID(email);
    }
    public User getUserByFirstName(String firstName){
    	return  dao.getUserByFirstName(firstName);
    }
    
    public List<User> getAllUserList(){
    	return  dao.getAllUserList();
    }
    
    public PrivacySettings getUserPvcySettings(int thisUserID){
    	return dao.getUserPvcySettings(thisUserID);
    }
    public void setPrivSet(int thisUserID,PrivacySettings updatePvcySettings){
    	 dao.setPrivSet(thisUserID,updatePvcySettings);
    }


}

