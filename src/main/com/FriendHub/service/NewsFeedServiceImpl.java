package main.com.FriendHub.service;

import java.util.ArrayList;
import java.util.List;

import main.com.FriendHub.dao.NewsFeedDao;
import main.com.FriendHub.model.Comments;
import main.com.FriendHub.model.StatusUpdate;
import main.com.FriendHub.model.StatusUpdateLikeDislikeCount;
import main.com.FriendHub.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("newsfeedservice")
@Transactional
public class NewsFeedServiceImpl implements NewsFeedService {
	
	@Autowired
    private NewsFeedDao dao;
	
	
	public String updateStatus(StatusUpdate statusUpdate){
		return dao.updateStatus(statusUpdate);
	}


	public List<StatusUpdate> getStatusUpdates(User user) {
		return dao.getStatusUpdates(user);
	}


	@Override
	public ArrayList<Comments> getCommentsByStatusUpdateID(StatusUpdate statusUpdateID) {
		return dao.getCommentsByStatusUpdateID(statusUpdateID);
	}


	@Override
	public int getLikesOrDislikesForCurrentUser(StatusUpdateLikeDislikeCount statusUpdate) {
		return dao.getLikesOrDislikesForCurrentUser(statusUpdate);
	}


	@Override
	public StatusUpdate getStatusByID(int statusUpdateId) {
		return dao.getStatusByID(statusUpdateId);
	}


	@Override
	public String updateLikeDisLikeCounterTable(StatusUpdateLikeDislikeCount statusUpdate) {
		return dao.updateLikeDisLikeCounterTable(statusUpdate);
	}


	@Override
	public String updateComment(StatusUpdate statusUpdate, User user,
			String comment) {
		return dao.updateComment(statusUpdate,user,comment);
	}


	@Override
	public Integer getLikeCountForStatusUpdate(
			StatusUpdateLikeDislikeCount statusUpdate) {
		return dao.getLikeCountForStatusUpdate(statusUpdate);	}


	@Override
	public Integer getDisLikeCountForStatusUpdate(
			StatusUpdateLikeDislikeCount statusUpdate) {
		
		return dao.getDisLikeCountForStatusUpdate(statusUpdate);
	}


	@Override
	public List<StatusUpdate> getStatusUpdatesByCateogry(User user, int category) {
		
		return dao.getStatusUpdatesByCateogry(user,category);
	}
	
	
}

