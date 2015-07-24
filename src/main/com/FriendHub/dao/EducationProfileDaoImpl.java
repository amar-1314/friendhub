package main.com.FriendHub.dao;

import java.util.List;

import main.com.FriendHub.model.EducationProfile;
import main.com.FriendHub.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository("EducationProfileDao")
public class EducationProfileDaoImpl extends AbstractDao implements EducationProfileDao {
	String resultflag ="false";
	 @SuppressWarnings("unchecked")
	public List<EducationProfile> findAllEducationProfiles(User user) {
		Criteria criteria = getSession().createCriteria(EducationProfile.class);
		criteria.add(Restrictions.eq("userID", user));
        return (List<EducationProfile>) criteria.list();
	}
	 
 public String addEducationDetails(EducationProfile educationprofile) {
		 
		 try{
			 getSession().saveOrUpdate(educationprofile);
			 resultflag ="true";
		 }catch (Exception e) {
		        e.printStackTrace();
		    } 
		    return resultflag ;
		}

}