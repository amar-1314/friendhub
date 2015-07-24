
package main.com.FriendHub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.com.FriendHub.model.Attachments;
import main.com.FriendHub.model.User;

@Repository("attachmentsDao")
public class AttachmentsDaoImpl extends AbstractDao implements AttachmentsDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = false)
	public void addAttachments(Attachments attachment){
		sessionFactory.getCurrentSession().save(attachment);
		System.out.println("Hello");
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Attachments> getListOfAttachments(User user, User friend) {
		List<Attachments> attachmentsList = new ArrayList<Attachments>();
		Criteria criteria = getSession().createCriteria(Attachments.class);
		Criterion rest1 = Restrictions.eq("senderID", user);
		Criterion rest2 = Restrictions.eq("receiverID", friend.getUserID());
		Criterion rest3 = Restrictions.eq("senderID", friend);
		Criterion rest4 = Restrictions.eq("receiverID", user.getUserID());
		criteria.createCriteria("messageID").add(Restrictions.or(Restrictions.and(rest1, rest2),
				Restrictions.and(rest3, rest4)));
		attachmentsList = criteria.list();
		return attachmentsList;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public Attachments find(int id) {
		List<Attachments> attachmentsList = new ArrayList<Attachments>();
		Criteria criteria = getSession().createCriteria(Attachments.class);
		Criterion rest1 = Restrictions.eq("id", id);
		criteria.createCriteria("messageID").add(rest1);
		attachmentsList = criteria.list();
		return attachmentsList.get(0);
	}

}
