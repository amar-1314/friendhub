package main.com.FriendHub.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.com.FriendHub.model.PrivacySettings;
import main.com.FriendHub.model.User;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	public void saveUser(User user) {
		persist(user);
	}

    public void saveUserProfile(User user)
    {
    	//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	//String datestring = dateFormat.format(user.getDob()); 
    	Query query = getSession().createSQLQuery("update user set First_Name = :fName , Last_Name = :lname, Middle_Name =:mname, Phone_Number =:phno, DOB =:dob, Address_Line_1 =:street, City =:city, State =:state, Zip =:zip, Gender =:gender, Country=:country"  +
				" where UserID = :userID");
query.setParameter("fName", user.getFirstName());
query.setParameter("userID", user.getUserID());
query.setParameter("lname", user.getlName());
query.setParameter("mname", user.getMiddleName());
query.setParameter("phno", user.getPhoneNumber());
query.setParameter("dob", user.getDob());
query.setParameter("street", user.getAddressLine1());
query.setParameter("city", user.getCity());
query.setParameter("state", user.getState());
query.setParameter("zip", user.getZip());
query.setParameter("gender", user.getGender());
query.setParameter("country", user.getCountry());
 query.executeUpdate();
    } 
    
    public void saveProfilePicture(User user,MultipartFile file)
    
    {
    	
    	byte[] bFile = null;
    	try {
			 bFile = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
    	byte[]  b = Base64.encodeBase64(bFile);
    	Query query = getSession().createSQLQuery("update user set Profile_Picture = :ppicture"  +
				" where UserID = :userID");
    	System.out.println("i am in query execution part");
query.setParameter("ppicture",b);
query.setParameter("userID", user.getUserID());
query.executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    public User getNameByEmailID(String email){
    	List<User> user = new ArrayList<User>();
    	
    	
    	Criteria criteria = getSession().createCriteria(User.class);
    	
    	criteria.add(Restrictions.eq("emailID", email));
    	user = criteria.list();
    	if(user.size() > 0)
    	return user.get(0);
    	else 
    		return null;
		
    }
 
 

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return criteria.list();
	}

	public void deleteUserByEmail(String email) {
		/*
		 * Query query =
		 * getSession().createSQLQuery("delete from user where EmailID = :email"
		 * ); query.setString("email", email); query.executeUpdate();
		 */
	}

	@SuppressWarnings("unchecked")
	public User getUserByID(int id) {
		List<User> user = new ArrayList<User>();
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userID", id));
		user = criteria.list();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public String getUserByEmail(String email) {

		List<String> user = new ArrayList<String>();

		Criteria criteria = getSession().createCriteria(User.class);
		criteria.setProjection(Projections.property("password"));

		criteria.add(Restrictions.eq("emailID", email));
		user = criteria.list();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;

	}

	public void registerUser(User user) {

		getSession().saveOrUpdate(user);
		int UserID=user.getUserID();
		try{
			PrivacySettings ps=new PrivacySettings();
			ps.setUserID(UserID);
			getSession().saveOrUpdate(ps);
		}
		catch(Exception e){
			System.out.println("Exception"+e);
		}
	}

	
	@SuppressWarnings("unchecked")
	public User getUserByEmailID(String email) {
		List<User> user = new ArrayList<User>();

		Criteria criteria = getSession().createCriteria(User.class);

		criteria.add(Restrictions.eq("emailID", email));
		user = criteria.list();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public String getSecQuesByEmail(String email) {
		List<String> user = new ArrayList<String>();
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.setProjection(Projections.property("securityQuestion"));

		criteria.add(Restrictions.eq("emailID", email));
		user = criteria.list();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;

	}

	@SuppressWarnings("unchecked")
	public String getSecQuesByName(String fname, String lname) {
		System.out.println("in dao");
		List<String> user = new ArrayList<String>();
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.setProjection(Projections.property("securityQuestion"));

		Criterion restFname = Restrictions.eq("firstName", fname);
		Criterion restLname = Restrictions.eq("lName", lname);
		criteria.add(Restrictions.and(restFname, restLname));

		/* criteria.add(Restrictions.eq("Last_Name", lname)); */

		user = criteria.list();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public String getSecAnsByEmail(String emailID) {
		List<String> user = new ArrayList<String>();
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.setProjection(Projections.property("securityAnswer"));

		criteria.add(Restrictions.eq("emailID", emailID));
		user = criteria.list();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	public String getEmailByName(String fname, String lname) {
		List<String> user = new ArrayList<String>();
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.setProjection(Projections.property("emailID"));

		Criterion restFname = Restrictions.eq("firstName", fname);
		Criterion restLname = Restrictions.eq("lName", lname);
		criteria.add(Restrictions.and(restFname, restLname));

		user = criteria.list();
		if (user.size() > 0)
			return user.get(0);
		else
			return null;
	}

	public String deactivateUserWithEmail(String email) {
		Query query = getSession().createSQLQuery("update user set Active_Flag=0 where EmailID = :email");
		query.setString("email", email);
		query.executeUpdate();

		return "success";

	}

	public String updateSecQuesAnsWithEmail(String secQues, String secAns,
			String emailID) {
		/*
		 * User user=new User(); Criteria criteria =
		 * getSession().createCriteria(User.class);
		 * 
		 * criteria.add(Restrictions.eq("emailID", emailID));
		 * System.out.println(user.getSecurityQuestion());
		 * user.setSecurityQuestion(secQues); user.setSecurityAnswer(secAns);
		 * System.out.println(user.getSecurityQuestion());
		 */
		Query query = getSession()
				.createSQLQuery(
						"update user set Security_Question=:secQues, Security_Answer=:secAns where EmailID = :email");
		query.setString("secQues", secQues);
		query.setString("secAns", secAns);
		query.setString("email", emailID);
		query.executeUpdate();

		return "success";
	}

	public String deleteUserWithEmail(String emailID) {
		Query query = getSession().createSQLQuery(
				"delete from user where EmailID = :email");
		query.setString("email", emailID);
		query.executeUpdate();
		return "success";
	}
    

	public String updateTwoFactorWithEmail(String emailID) {
		Query query = getSession().createSQLQuery(
				"update user set 2F_Auth_flag=1 where EmailID = :email");
		query.setString("email", emailID);
		query.executeUpdate();
		return "success";
	}

    public String disableTwoFactorWithEmail(String emailID){
    	Query query = getSession().createSQLQuery(
				"update user set 2F_Auth_flag=0 where EmailID = :email");
		query.setString("email", emailID);
		query.executeUpdate();
		return "success";
    	
    }
	public String updatePassword(String encodedPwd, String emailID) {
		Query query = getSession().createSQLQuery(
				"update user set Password=:enPwd where EmailID = :email");
		query.setString("email", emailID);
		query.setString("enPwd", encodedPwd);
		query.executeUpdate();
		return "success";
	}

	// @SuppressWarnings("unchecked")
	
	 @SuppressWarnings("unchecked")
	public User getUserByFirstName(String firstName)
	 {
		 
		 List<User> user = new ArrayList<User>();
		
			Criteria criteria = getSession().createCriteria(User.class);			
	        Criterion rest1 =Restrictions.eq("firstName", firstName);
	        Criterion rest2 = Restrictions.eq("activeFlag", 1);
	        criteria.add(Restrictions.and(rest1, rest2));   
			user = criteria.list();
			if (user.size() > 0)
				return user.get(0);
			else
				return null;
		 
	
	 }
	 @SuppressWarnings("unchecked")
	public List<User> getAllUserList()
	 {
		 	List<User> user = new ArrayList<User>();
			Criteria criteria = getSession().createCriteria(User.class);
			criteria.add(Restrictions.eq("activeFlag", 1));
			 user = criteria.list();
			 return user;
			
	 }
	 
	 @SuppressWarnings("unchecked")
	public  PrivacySettings getUserPvcySettings(int thisUserID){
		 	List<PrivacySettings> ps = new ArrayList<PrivacySettings>();
		 Criteria criteria = getSession().createCriteria(PrivacySettings.class);

			criteria.add(Restrictions.eq("userID", thisUserID));
			ps=criteria.list();
			if(ps.size()>0)
				return ps.get(0);
			else
				return null;
	 }
	 
	 public void setPrivSet(int thisUserID,PrivacySettings updatePvcySettings){
	    	Byte searchFlag=updatePvcySettings.getSearchableFlag();
	    	char profInfoFlag=updatePvcySettings.getProfileDataFlag();
	    	char msgFlag=updatePvcySettings.getMessageFlag();
	    	char statFlag=updatePvcySettings.getStatusFlag();
	    	Query query = getSession()
					.createSQLQuery(
							"update Privacy_Settings set  Searchable_Flag=:searchFlag, Profile_Data_Flag=:profInfoFlag, Messagable_Flag=:msgFlag, Status_Flag=:statFlag where User_ID=:userID");
			query.setByte("searchFlag", searchFlag);
			query.setCharacter("profInfoFlag", profInfoFlag);
			query.setCharacter("msgFlag", msgFlag);
			query.setCharacter("statFlag", statFlag);
			query.setInteger("userID", thisUserID);

			query.executeUpdate();
	    	
	    }


}
