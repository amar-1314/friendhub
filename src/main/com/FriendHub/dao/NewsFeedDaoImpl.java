package main.com.FriendHub.dao;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import main.com.FriendHub.model.Comments;
import main.com.FriendHub.model.FriendList;
import main.com.FriendHub.model.StatusUpdate;
import main.com.FriendHub.model.StatusUpdateLikeDislikeCount;
import main.com.FriendHub.model.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("newFeedDao")
public class NewsFeedDaoImpl extends AbstractDao implements NewsFeedDao {

	@Override
	public String updateStatus(StatusUpdate statusUpdate) {
		persist(statusUpdate);
		return "success";

	}

	@SuppressWarnings("unchecked")
	public List<StatusUpdate> getStatusUpdates(User user) {

		List<User> friendList = new ArrayList<User>();
		List<Integer> friends = new ArrayList<Integer>();

		Criteria criteria = getSession().createCriteria(FriendList.class);

		criteria.add(Restrictions.eq("userID", user));
		criteria.add(Restrictions.eq("requestStatus", 'Y'));
		criteria.setProjection(Projections.property("friendUserID"));

		friendList = criteria.list();

		for (int i = 0; i < friendList.size(); i++) {
			friends.add(friendList.get(i).getUserID());
		}
		friends.add(user.getUserID());
		List<StatusUpdate> statusUpdate = new ArrayList<StatusUpdate>();

		java.util.Date date= new java.util.Date();
		Timestamp now =new Timestamp(date.getTime());
		 
		
		java.util.Date date24 = new java.util.Date(System.currentTimeMillis() - (24 * 60 * 60 * 1000));
		
		
		Timestamp now24 =new Timestamp(date24.getTime());
		
		Query query = getSession().createQuery("SELECT b FROM StatusUpdate b WHERE User_ID IN (:fList) and Time_Stamp between :yest and :now ");
		query.setParameterList("fList", friends);
		query.setParameter("now", now);
		query.setParameter("yest", now24);
		
		statusUpdate = query.list();

		if (statusUpdate.size() > 0)
			return statusUpdate;
		else
			return null;

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Comments> getCommentsByStatusUpdateID(
			StatusUpdate statusUpdate) {
		ArrayList<Comments> comments = new ArrayList<Comments>();
		Criteria criteria = getSession().createCriteria(Comments.class);

		criteria.add(Restrictions.eq("status_ID", statusUpdate));
		comments = (ArrayList<Comments>) criteria.list();
		if (comments.size() > 0)
			return comments;
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public int getLikesOrDislikesForCurrentUser(
			StatusUpdateLikeDislikeCount statusUpdate) {
		List<Integer> likeOrDislike = new ArrayList<Integer>();
		Criteria criteria = getSession().createCriteria(
				StatusUpdateLikeDislikeCount.class);
		criteria.add(Restrictions.eq("statusUpdateLikeDisLikeKeys",
				statusUpdate.getStatusUpdateLikeDisLikeKeys()));
		criteria.setProjection(Projections.property("LikeOrDisLikeFlag"));
		likeOrDislike = criteria.list();
		if (likeOrDislike.size() == 1)
			return likeOrDislike.get(0);
		else
			return 0;
	}

	@SuppressWarnings("unchecked")
	public StatusUpdate getStatusByID(int statusUpdateId) {
		List<StatusUpdate> statusUpdate = new ArrayList<StatusUpdate>();

		Criteria criteria = getSession().createCriteria(StatusUpdate.class);
		criteria.add(Restrictions.eq("status_Update_ID", statusUpdateId));
		statusUpdate = criteria.list();
		if (statusUpdate.size() == 1)
			return statusUpdate.get(0);
		else
			return null;
	}

	@Override
	public String updateLikeDisLikeCounterTable(
			StatusUpdateLikeDislikeCount statusUpdate) {

		getSession().saveOrUpdate(statusUpdate);
		return null;
	}

	@Override
	public String updateComment(StatusUpdate statusUpdate, User user,
			String comment) {
		Comments comments = new Comments();
		comments.setStatus_ID(statusUpdate);
		comments.setCommentorUserID(user);
		comments.setComment(comment);
		persist(comments);
		return "success";
	}

	@Override
	public Integer getLikeCountForStatusUpdate(
			StatusUpdateLikeDislikeCount statusUpdate) {
		int statusUpdateID = statusUpdate.getStatusUpdateLikeDisLikeKeys().getStatus_update_id().getStatus_Update_ID();
		
		Query query = getSession().createSQLQuery(
				"SELECT COUNT(*) FROM Statusupdatelikedislikecount WHERE status_update_id = :statUpID and LikeOrDisLikeFlag = 1");
		query.setParameter("statUpID", statusUpdateID);
		BigInteger test  = (BigInteger) query.uniqueResult();
		test.intValueExact();
		
		return test.intValueExact();
		
	}

	@Override
	public Integer getDisLikeCountForStatusUpdate(
			StatusUpdateLikeDislikeCount statusUpdate) {
int statusUpdateID = statusUpdate.getStatusUpdateLikeDisLikeKeys().getStatus_update_id().getStatus_Update_ID();
		
		Query query = getSession().createSQLQuery(
				"SELECT COUNT(*) FROM Statusupdatelikedislikecount WHERE status_update_id = :statUpID and LikeOrDisLikeFlag = 0");
		query.setParameter("statUpID", statusUpdateID);
		BigInteger test  = (BigInteger) query.uniqueResult();
		test.intValueExact();
		
		return test.intValueExact();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusUpdate> getStatusUpdatesByCateogry(User user, int category) {
		List<User> friendList = new ArrayList<User>();
		List<Integer> friends = new ArrayList<Integer>();

		Criteria criteria = getSession().createCriteria(FriendList.class);

		criteria.add(Restrictions.eq("userID", user));
		criteria.add(Restrictions.eq("requestStatus", 'Y'));
		criteria.add(Restrictions.eq("categoryID", category));
		criteria.setProjection(Projections.property("friendUserID"));

		friendList = criteria.list();

		for (int i = 0; i < friendList.size(); i++) {
			friends.add(friendList.get(i).getUserID());
		}
		friends.add(user.getUserID());
		List<StatusUpdate> statusUpdate = new ArrayList<StatusUpdate>();

		java.util.Date date= new java.util.Date();
		Timestamp now =new Timestamp(date.getTime());
		 
		
		java.util.Date date24 = new java.util.Date(System.currentTimeMillis() - (24 * 60 * 60 * 1000));
		
		
		Timestamp now24 =new Timestamp(date24.getTime());
		
		Query query = getSession().createQuery("SELECT b FROM StatusUpdate b WHERE User_ID IN (:fList) and Time_Stamp between :yest and :now ");
		query.setParameterList("fList", friends);
		query.setParameter("now", now);
		query.setParameter("yest", now24);
		
		statusUpdate = query.list();

		if (statusUpdate.size() > 0)
			return statusUpdate;
		else
			return null;
	}

}
