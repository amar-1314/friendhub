package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.model.PrivacySettings;
import main.com.FriendHub.model.User;

import org.springframework.web.multipart.MultipartFile;

 
public interface UserService {
 
    void saveUser(User user);
     
    List<User> findAllUsers(); 
     
    void deleteUserByEmail(String ssn);
    String getUserByEmail(String email);
    User getUserByEmailID(String email);
    public User getUserByID(int id);
    void registerUser(User user);
     void saveUserProfile(User user);
    void saveProfilePicture(User user,MultipartFile file);
	
    String getSecQuesByName(String fname,String lname);
    String getSecQuesByEmail(String email); 
    public String getSecAnsByEmail(String emailID);
    public String getEmailByName(String fname,String lname);
    public String deactivateUserWithEmail(String emailID);
    public String deleteUserWithEmail(String emailID);
    public String updateSecQuesAnsWithEmail(String secQues, String secAns, String emailID);
    public String updateTwoFactorWithEmail(String emailID);
    public String updatePassword(String encodedPwd, String emailID);
    public User getNameByEmailID(String email);
    public User getUserByFirstName(String firstName);
    public List<User> getAllUserList();
    public String disableTwoFactorWithEmail(String emailID);
    public PrivacySettings getUserPvcySettings(int thisUserID);
    public void setPrivSet(int thisUserID,PrivacySettings updatePvcySettings);
}

