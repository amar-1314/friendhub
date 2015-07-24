package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import main.com.FriendHub.compositekeys.StatusUpdateLikeDisLikeKeys;

@Entity
@Table(name="statusupdatelikedislikecount")
public class StatusUpdateLikeDislikeCount {
	 
	 
	 @EmbeddedId
	 private StatusUpdateLikeDisLikeKeys statusUpdateLikeDisLikeKeys;
	
	 @Column(name = "LikeOrDisLikeFlag")
	 private int LikeOrDisLikeFlag;


	public int getLikeOrDisLikeFlag() {
		return LikeOrDisLikeFlag;
	}


	public void setLikeOrDisLikeFlag(int likeOrDisLikeFlag) {
		LikeOrDisLikeFlag = likeOrDisLikeFlag;
	}


	public StatusUpdateLikeDisLikeKeys getStatusUpdateLikeDisLikeKeys() {
		return statusUpdateLikeDisLikeKeys;
	}


	public void setStatusUpdateLikeDisLikeKeys(
			StatusUpdateLikeDisLikeKeys statusUpdateLikeDisLikeKeys) {
		this.statusUpdateLikeDisLikeKeys = statusUpdateLikeDisLikeKeys;
	}
	 
}
