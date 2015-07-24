package main.com.FriendHub.dao;

import java.util.List;
import main.com.FriendHub.Utilities.GroupedMessageNotifications;
import main.com.FriendHub.model.MessageNotifications;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("messageNotificationsDao")
public class MessageNotificationsDaoImpl extends AbstractDao implements
		MessageNotificationsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * @Transactional(readOnly = true) public Messages getMessage(Long
	 * messageId) { Messages message = (Messages)
	 * sessionFactory.getCurrentSession().get( Messages.class, messageId); if
	 * (log.isDebugEnabled()) { log.debug("getMessage: " + message); } return
	 * message; }
	 * 
	 * @Transactional(readOnly = false) public void addMessage(Messages message)
	 * { sessionFactory.getCurrentSession().save(message); }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * @Transactional(readOnly = true) public List<Messages>
	 * getRecentMessages(User user, User friend) { List<Messages> messageList =
	 * new ArrayList<Messages>(); Criteria criteria =
	 * getSession().createCriteria(Messages.class); Criterion rest1 =
	 * Restrictions.eq("senderID", user); Criterion rest2 =
	 * Restrictions.eq("receiverID", friend.getUserID()); Criterion rest3 =
	 * Restrictions.eq("senderID", friend); Criterion rest4 =
	 * Restrictions.eq("receiverID", user.getUserID());
	 * criteria.add(Restrictions.or(Restrictions.and(rest1, rest2),
	 * Restrictions.and(rest3, rest4)));
	 * criteria.addOrder(Order.asc("timeStamp")); messageList = criteria.list();
	 * return messageList; }
	 */

	@Transactional(readOnly = false)
	public void addMessageNotification(MessageNotifications notification) {
		sessionFactory.getCurrentSession().save(notification);

	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<GroupedMessageNotifications> getRecentMessageNotifications(int userID) {
		List<GroupedMessageNotifications> results = getSession()
				.createCriteria(MessageNotifications.class).add(Restrictions.eq("receiverID", userID))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.groupProperty("senderID"),
										"senderID")
								.add(Projections.rowCount(), "count"))
				.setResultTransformer(
						Transformers
								.aliasToBean(GroupedMessageNotifications.class))
				.list();
		System.out.println(results);
		return results;
	}
	
	@Transactional(readOnly = false)
	public void deleteNotifications(int friendID, int userID){
		Query query = getSession().createSQLQuery(
				"delete from message_notifications where Sender_ID = :friendID and Receiver_ID = :userID");
		query.setInteger("friendID", friendID);
		query.setInteger("userID", userID);
		query.executeUpdate();
	}
	
}
