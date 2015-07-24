package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int comment_ID;

	@ManyToOne
	@JoinColumn(name = "STATUS_ID", nullable = false) 
	private StatusUpdate status_ID;

	@ManyToOne
	@JoinColumn(name = "COMMENTOR_USER_ID", nullable = false)
	private User commentorUserID;

	@Column(name = "COMMENT")
	private String comment;

	public int getComment_ID() {
		return comment_ID;
	}

	public void setComment_ID(int comment_ID) {
		this.comment_ID = comment_ID;
	}

	public StatusUpdate getStatus_ID() {
		return status_ID;
	}

	public void setStatus_ID(StatusUpdate status_ID) {
		this.status_ID = status_ID;
	}

	public User getCommentorUserID() {
		return commentorUserID;
	}

	public void setCommentorUserID(User commentorUserID) {
		this.commentorUserID = commentorUserID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
