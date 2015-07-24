package main.com.FriendHub.dao;

import java.util.List;

import main.com.FriendHub.model.User;
import main.com.FriendHub.model.WorkProfile;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("WorkProfileDao")
public class WorkProfileDaoImpl extends AbstractDao implements WorkProfileDao {
	String resultflag ="false";
	 @SuppressWarnings("unchecked")
	public List<WorkProfile> findAllWorkProfiles(User user) {
		Criteria criteria = getSession().createCriteria(WorkProfile.class);
		criteria.add(Restrictions.eq("userID", user));
        return (List<WorkProfile>) criteria.list();
	}
	 
	 public String addWorkDetails(WorkProfile workprofile) {
		 
		 try{
			 getSession().saveOrUpdate(workprofile);
			 resultflag ="true";
		 }catch (Exception e) {
		        e.printStackTrace();
		    } 
		    return resultflag ;
		}
		

}
