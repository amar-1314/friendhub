package main.com.FriendHub.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="education_profile")
public class EducationProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int education_profile_ID;
    
    @ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
    private User userID;	
    
    @Column(name = "COLLEGE_NAME")
    private String collegeName; 
    
	@Column(name = "FROM_DATE", nullable = false)
	private Date fromDate;

	@Column(name = "TO_DATE")
	private Date toDate;

	@Column(name = "DEGREE_OBTAINED")
    private String degreeObtained;

	public EducationProfile() {
		super();
	}
	public EducationProfile(int i, User user, String collegename,
			java.sql.Date parsedDate, Date todate1) {
		this.education_profile_ID = i;
		this.userID = user;
		this.collegeName = collegename;
		this.fromDate = parsedDate;
		this.toDate = todate1;
		
	}
	
	public EducationProfile(User user, String collegename,
			java.sql.Date parsedDate, Date todate1) {
		
		this.userID = user;
		this.collegeName = collegename;
		this.fromDate = parsedDate;
		this.toDate = todate1;
		
	}
	public int getEducation_profile_ID() {
		return education_profile_ID;
	}

	public void setEducation_profile_ID(int education_profile_ID) {
		this.education_profile_ID = education_profile_ID;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getDegreeObtained() {
		return degreeObtained;
	}

	public void setDegreeObtained(String degreeObtained) {
		this.degreeObtained = degreeObtained;
	} 
}

