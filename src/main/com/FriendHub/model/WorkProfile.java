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
@Table(name = "work_profile")
public class WorkProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int work_ProfileID;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User userID;

	@Column(name = "COMPANY_NAME", nullable = false)
	private String companyName;

	@Column(name = "FROMDATE", nullable = false)
	private Date fromDate;

	@Column(name = "TODATE")
	private Date toDate;
	
	public WorkProfile() {
		super();
	}

	public WorkProfile(int i, User user, String companyName2,
			java.sql.Date parsedDate, Date todate1) {
		this.work_ProfileID = i;
		this.userID = user;
		this.companyName = companyName2;
		this.fromDate = parsedDate;
		this.toDate = todate1;
		
	}

	public WorkProfile( User user, String companyName2,
			java.sql.Date parsedDate, Date todate1) {
		
		this.userID = user;
		this.companyName = companyName2;
		this.fromDate = parsedDate;
		this.toDate = todate1;
		
	}


	public int getWork_ProfileID() {
		return work_ProfileID;
	}
	


	public void setWork_ProfileID(int work_ProfileID) {
		this.work_ProfileID = work_ProfileID;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

}

