package main.com.FriendHub.dao;

import java.util.ArrayList;
import java.util.List;

import main.com.FriendHub.model.FriendList;
import main.com.FriendHub.model.User;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("friendlistdao")
public class FriendListDaoImpl extends AbstractDao implements FriendListDao {

	@SuppressWarnings("unchecked")
	public List<FriendList> getFriendList(User ID) {

		List<FriendList> friendList = new ArrayList<FriendList>();
		Criteria criteria = getSession().createCriteria(FriendList.class);
		Criterion rest1 = Restrictions.eq("userID", ID);
		Criterion rest2 = Restrictions.eq("requestStatus", 'Y');
		criteria.add(Restrictions.and(rest1, rest2));
		criteria.createCriteria("friendUserID")
				.addOrder(Order.asc("firstName"));
		friendList = criteria.list();
		return friendList;

	}

	@Override
	public int getFriendCount(User Uid) {
		// TODO Auto-generated method stub
		int count = 0;
		Criteria criteria = getSession().createCriteria(FriendList.class);
		criteria.add(Restrictions.eq("userID", Uid));
		count = criteria.list().size();

		return count;
	}

	@SuppressWarnings("unchecked")
	public List<FriendList> getFriendListByCategory(User userID,
			Integer categoryID) {
		// TODO Auto-generated method stub

		List<FriendList> friendListByCategory = new ArrayList<FriendList>();

		Criteria criteria = getSession().createCriteria(FriendList.class);

		Criterion rest1 = Restrictions.eq("userID", userID);
		Criterion rest2 = Restrictions.eq("categoryID", categoryID);
		criteria.add(Restrictions.and(rest1, rest2));
		friendListByCategory = criteria.list();

		return friendListByCategory;
	}

	public void addFriend(FriendList friend) {

		persist(friend);
	}

	@SuppressWarnings("unchecked")
	public List<User> checkFriends(User userID, User friendID) {
		Criteria criteria = getSession().createCriteria(FriendList.class);
		Criterion rest1 = Restrictions.eq("userID", userID);
		Criterion rest2 = Restrictions.eq("friendUserID", friendID);
		criteria.add(Restrictions.and(rest1, rest2));

		return criteria.list();
	}

	public void unfriend(User friend) {

		org.hibernate.Query query = getSession().createQuery(
				"delete FriendList where friendUserID = :friend");
		query.setParameter("friend", friend);

		int result = query.executeUpdate();

		if (result > 0) {
			System.out.println("Expensive products was removed");
		}

	}

}
