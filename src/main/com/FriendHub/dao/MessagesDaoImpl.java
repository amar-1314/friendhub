package main.com.FriendHub.dao;

import java.util.ArrayList;
import java.util.List;

import main.com.FriendHub.model.Messages;
import main.com.FriendHub.model.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("messagesDao")
public class MessagesDaoImpl extends AbstractDao implements MessagesDao {

	private static final Logger log = LoggerFactory
			.getLogger(MessagesDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	public Messages getMessage(Long messageId) {
		Messages message = (Messages) sessionFactory.getCurrentSession().get(
				Messages.class, messageId);
		if (log.isDebugEnabled()) {
			log.debug("getMessage: " + message);
		}
		return message;
	}

	@Transactional(readOnly = false)
	public void addMessage(Messages message) {
		sessionFactory.getCurrentSession().save(message);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Messages> getRecentMessages(User user, User friend) {
		List<Messages> messageList = new ArrayList<Messages>();
		Criteria criteria = getSession().createCriteria(Messages.class);
		Criterion rest1 = Restrictions.eq("senderID", user);
		Criterion rest2 = Restrictions.eq("receiverID", friend.getUserID());
		Criterion rest3 = Restrictions.eq("senderID", friend);
		Criterion rest4 = Restrictions.eq("receiverID", user.getUserID());
		criteria.add(Restrictions.or(Restrictions.and(rest1, rest2),
				Restrictions.and(rest3, rest4)));
		criteria.addOrder(Order.asc("timeStamp"));
		messageList = criteria.list();
		return messageList;
	}
}
