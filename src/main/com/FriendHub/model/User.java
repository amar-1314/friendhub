package main.com.FriendHub.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import main.com.FriendHub.Utilities.ProfilePicture;
 
@Entity
@Table(name="user")
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  userID;
    
    @Column(name = "EMAILID", nullable = false)
    private String emailID;
 
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    
    @Column(name = "MIDDLE_NAME")
    private String middleName;
          
    @Column(name = "LAST_NAME", nullable = false)
    private String lName;
    
    
    @Column(name = "PHONE_NUMBER")
    private Integer phoneNumber;

    @Column(name = "DOB")
    private Date dob;
    
    @Column(name = "ADDRESS_LINE_1")
    private String addressLine1;
    
    @Column(name = "ADDRESS_LINE_2")
    private String addressLine2;
    
    @Column(name = "CITY")
    private String city;
    
    @Column(name = "STATE")
    private String state;
    
    @Column(name = "ZIP")
    private String zip;
    
    @Column(name = "COUNTRY")
    private String country;
    
    @Column(name = "GENDER")
    private String gender;
    
    @Column(name = "PROFILE_PICTURE")
    private Blob profilePicture;
    
    @Column(name = "2F_AUTH_FLAG")
    private Byte twoFactorAuthFlag=0;
    
    @Column(name = "SECURITY_QUESTION")
    private String securityQuestion="What is your pet?";
    
    @Column(name = "SECURITY_ANSWER")
    private String securityAnswer="Cat";
    
    @Column(name = "ACTIVE_FLAG")
    private int activeFlag = 1;
    
    public String getProfilePicutreBase64String() {
    	ProfilePicture profilePicture = new ProfilePicture();
    	if(this.getProfilePicture() == null){
    		return "";
    	}
    	return profilePicture.getProfilePictureByteArray(this.getProfilePicture());
	}

	public void setProfilePicutreBase64String(String profilePicutreBase64String) {
		this.profilePicutreBase64String = profilePicutreBase64String;
	}

	@Transient
    private String profilePicutreBase64String;
    
    public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	} 

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		
		this.password = password;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Blob getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Blob profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Byte getTwoFactorAuthFlag() {
		return twoFactorAuthFlag;
	}

	public void setTwoFactorAuthFlag(Byte twoFactorAuthFlag) {
		this.twoFactorAuthFlag = twoFactorAuthFlag;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

}

