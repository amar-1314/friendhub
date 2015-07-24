package main.com.FriendHub.dao;

import java.util.ArrayList;
import java.util.List;

import main.com.FriendHub.model.Comments;
import main.com.FriendHub.model.StatusUpdate;
import main.com.FriendHub.model.StatusUpdateLikeDislikeCount;
import main.com.FriendHub.model.User;

public interface NewsFeedDao {
	String updateStatus(StatusUpdate statusUpdate);
	List<StatusUpdate> getStatusUpdates(User user);
	List<StatusUpdate> getStatusUpdatesByCateogry(User user, int category);
	ArrayList<Comments> getCommentsByStatusUpdateID(StatusUpdate statusUpdateID);
	int getLikesOrDislikesForCurrentUser(StatusUpdateLikeDislikeCount statusUpdate);
	StatusUpdate getStatusByID(int statusUpdateId);
	String updateLikeDisLikeCounterTable(StatusUpdateLikeDislikeCount statusUpdate);
	String updateComment(StatusUpdate statusUpdate, User user, String comment);
	Integer getLikeCountForStatusUpdate(StatusUpdateLikeDislikeCount statusUpdate);
	Integer getDisLikeCountForStatusUpdate(StatusUpdateLikeDislikeCount statusUpdate);
}


