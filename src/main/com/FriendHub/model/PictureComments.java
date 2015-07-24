package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "picture_comments")
public class PictureComments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_ID;

	@Column(name = "PICTURE_ID", nullable = false)
	private int pictureID;

	@Column(name = "COMMENTOR_USER_ID", nullable = false)
	private int commentorUserID;

	@Column(name = "COMMENT")
	private String comment;

	public int getComment_ID() {
		return comment_ID;
	}

	public void setComment_ID(int comment_ID) {
		this.comment_ID = comment_ID;
	}

	public int getPictureID() {
		return pictureID;
	}

	public void setPictureID(int pictureID) {
		this.pictureID = pictureID;
	}

	public int getCommentorUserID() {
		return commentorUserID;
	}

	public void setCommentorUserID(int commentorUserID) {
		this.commentorUserID = commentorUserID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
