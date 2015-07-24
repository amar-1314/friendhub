package main.com.FriendHub.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Pictures {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int picture_ID;

	@Column(name = "ALBUM_ID", nullable = false)
	private int albumID;

	@Column(name = "PICTURE")
	private Blob picture;

	@Column(name = "LIKE_COUNT")
	private int likeCount;

	@Column(name = "DISLIKE_COUNT")
	private int DislikeCount;

	@Column(name = "COMMENT_COUNT")
	private int commentCount;

	public int getPicture_ID() {
		return picture_ID;
	}

	public void setPicture_ID(int picture_ID) {
		this.picture_ID = picture_ID;
	}

	public int getAlbumID() {
		return albumID;
	}

	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getDislikeCount() {
		return DislikeCount;
	}

	public void setDislikeCount(int dislikeCount) {
		DislikeCount = dislikeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

}
