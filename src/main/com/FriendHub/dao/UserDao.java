package main.com.FriendHub.dao;


import java.util.List;

import main.com.FriendHub.model.PrivacySettings;
import main.com.FriendHub.model.User;

import org.springframework.web.multipart.MultipartFile;

 
public interface UserDao {
 
    void saveUser(User user);
     
    List<User> findAllUsers();
     
    void deleteUserByEmail(String email);
    
    String getUserByEmail(String email);
    User getUserByID(int id);
    void registerUser(User user);
    
    User getUserByEmailID(String email);
    
     void saveUserProfile(User user);
     
     void saveProfilePicture(User user,MultipartFile file);
 	

    String getSecQuesByEmail(String email);
    String getSecQuesByName(String fname,String lname);
    String getSecAnsByEmail(String emailID);
    String getEmailByName(String fname,String lname);
    String deactivateUserWithEmail(String emailID);
    String deleteUserWithEmail(String emailID);
    String updateSecQuesAnsWithEmail(String secQues, String secAns, String emailID);
    String updateTwoFactorWithEmail(String emailID);
    String updatePassword(String encodedPwd, String emailID);
    String disableTwoFactorWithEmail(String emailID);
    User getNameByEmailID(String email);
    User getUserByFirstName(String firstName);

	List<User> getAllUserList();
  PrivacySettings getUserPvcySettings(int thisUserID);
  void setPrivSet(int thisUserID,PrivacySettings updatePvcySettings);


    
}

