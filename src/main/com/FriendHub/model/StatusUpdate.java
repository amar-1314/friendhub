package main.com.FriendHub.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="statusupdate")
public class StatusUpdate {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_Update_ID;
    
    @ManyToOne
    @JoinColumn(name = "User_ID")
    private User userID;
 
    @Column(name = "STATUS_UPDATE", nullable = false)
    private String statusUpdate;
    
    @Column(name = "TIME_STAMP", nullable = false)
    private Timestamp timeStamp;
    
    @Transient
    private int likeCount;
    
    @Transient
    private int dislikeCount;
    
    @Transient
    private int commentCount;
    
    @Transient
    private int likeOrDislike;

    
    public int getLikeOrDislike() {
		return likeOrDislike;
	}


	public void setLikeOrDislike(int likeOrDislike) {
		this.likeOrDislike = likeOrDislike;
	}


	public StatusUpdate() {
    }
    
    
    public StatusUpdate(String message, User user) {
        this.statusUpdate = message;
        this.timeStamp = new Timestamp(System.currentTimeMillis());
        this.userID = user;
    }
    
	public int getStatus_Update_ID() {
		return status_Update_ID;
	}

	public void setStatus_Update_ID(int status_Update_ID) {
		this.status_Update_ID = status_Update_ID;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public String getStatusUpdate() {
		return statusUpdate;
	}

	public void setStatusUpdate(String statusUpdate) {
		this.statusUpdate = statusUpdate;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
    
}