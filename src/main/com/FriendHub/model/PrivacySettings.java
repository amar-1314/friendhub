package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="privacy_settings")
public class PrivacySettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int privacy_Settings_ID;
    
    @Column(name = "USER_ID", nullable = false)
    private int userID;	
    
    @Column(name = "SEARCHABLE_FLAG")
    private Byte searchableFlag = 0;    

    @Column(name = "PROFILE_DATA_FLAG")
    private char profileDataFlag = 'P'; 
    
    @Column(name = "MESSAGABLE_FLAG")
    private char messageFlag='P'; 
    
    @Column(name = "STATUS_FLAG")
    private char statusFlag='P';

	public int getPrivacy_Settings_ID() {
		return privacy_Settings_ID;
	}

	public void setPrivacy_Settings_ID(int privacy_Settings_ID) {
		this.privacy_Settings_ID = privacy_Settings_ID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Byte getSearchableFlag() {
		return searchableFlag;
	}

	public void setSearchableFlag(Byte searchableFlag) {
		this.searchableFlag = searchableFlag;
	}

	public char getProfileDataFlag() {
		return profileDataFlag;
	}

	public void setProfileDataFlag(char profileDataFlag) {
		this.profileDataFlag = profileDataFlag;
	}

	public char getMessageFlag() {
		return messageFlag;
	}

	public void setMessageFlag(char messageFlag) {
		this.messageFlag = messageFlag;
	}

	public char getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(char statusFlag) {
		this.statusFlag = statusFlag;
	} 
}
