package main.com.FriendHub.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.com.FriendHub.Utilities.EmailHelper;
import main.com.FriendHub.Utilities.SessionManager;
import main.com.FriendHub.compositekeys.StatusUpdateLikeDisLikeKeys;
import main.com.FriendHub.model.Comments;
import main.com.FriendHub.model.StatusUpdate;
import main.com.FriendHub.model.StatusUpdateLikeDislikeCount;
import main.com.FriendHub.model.User;
import main.com.FriendHub.service.FriendListService;
import main.com.FriendHub.service.NewsFeedService;
import main.com.FriendHub.service.UserService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("deprecation")
@Controller
public class LoginController {

	int otpLoginSent;
	@Autowired
	UserService service;

	@Autowired
	FriendListService friendListservice;

	@Autowired
	BCryptPasswordEncoder passwordEncoder; //SHA1 Supported Encoder Used By Spring Security

	@Autowired
	private NewsFeedService newsFeedService;
	/* 
	 * Authenticate the User
	 * */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userCheck(@RequestParam("username") String userName,
			@RequestParam("password") String password, HttpSession session) {
		String message = "";
		User user = service.getUserByEmailID(userName);
		ModelAndView loginView = new ModelAndView("index");
		ModelAndView homeModel = new ModelAndView("home");
		if(user!=null){
			if (passwordEncoder.matches(password, user.getPassword())) {
				System.out.println(user.getTwoFactorAuthFlag());
				if(user.getTwoFactorAuthFlag()==0){
					SessionManager.setSessionAttributes(session.getId(), user);
					List<StatusUpdate> statusUpdateList = newsFeedService.getStatusUpdates(user);


				Map<StatusUpdate, ArrayList<Comments>> statusComments = new HashMap<StatusUpdate, ArrayList<Comments>>();
				homeModel.addObject("user", user);
				if(statusUpdateList != null ){
					for(int i =0; i<statusUpdateList.size() ; i++)
					{
						StatusUpdateLikeDislikeCount statusUpdateLikeDislikeCount = new StatusUpdateLikeDislikeCount();
						StatusUpdateLikeDisLikeKeys statusUpdateLikeDisLikeKeys = new StatusUpdateLikeDisLikeKeys(statusUpdateList.get(i),user);
						statusUpdateLikeDislikeCount.setStatusUpdateLikeDisLikeKeys(statusUpdateLikeDisLikeKeys);
						statusUpdateList.get(i).setLikeOrDislike(newsFeedService.getLikesOrDislikesForCurrentUser(statusUpdateLikeDislikeCount));
						statusUpdateList.get(i).setLikeCount(newsFeedService.getLikeCountForStatusUpdate(statusUpdateLikeDislikeCount));
						statusUpdateList.get(i).setDislikeCount(newsFeedService.getDisLikeCountForStatusUpdate(statusUpdateLikeDislikeCount));
						statusComments.put(statusUpdateList.get(i), newsFeedService
								.getCommentsByStatusUpdateID(statusUpdateList
										.get(i)));

					}
					homeModel.addObject("statusCommentsMap", statusComments);
				}
					return homeModel;
				}
				else {
					System.out.println("2 f active");
					try{
						
						Random rnd = new Random();
						otpLoginSent = 100000 + rnd.nextInt(900000);
						System.out.println("random number" + otpLoginSent);
						Resource r = new ClassPathResource("applicationContext.xml");
						BeanFactory b = new XmlBeanFactory(r); /*
						 * new FileSystemResource(
						 * "rest-servlet.xml")
						 */
						EmailHelper m = (EmailHelper) b.getBean("emailHelper");
						String sender = "hubbmate@gmail.com";// write here sender gmail
						// id
						String receiver = user.getEmailID();// write here receiver id
						m.sendMail(sender, receiver, "OTP for your FriendHub Login",
								"Ypu had opted for 2 Factor Authentication. To Login, please enter the following random number on the login page"+Integer.toString(otpLoginSent));
						message="OTP Sent. Please check mail";
						loginView.addObject("OTPmessage",message);
						loginView.addObject("emailcopy",user.getEmailID());	
						String hideOrUnhideOTPBlock = "block";
						loginView.addObject("hideOrUnhideOTPBlock", hideOrUnhideOTPBlock );
						return loginView;

					}
					catch(Exception e)
					{
						message="Could not send email with OTP";
						loginView.addObject("OTPmessage",message);
						
						System.out.println("Could not send email");
						return loginView;
					}

				}
			} 
			else
			{

				message = "Invalid Username/Password";
				loginView.addObject("message", message);
				return loginView;
			}

		}
		else
		{
			message = "Invalid Username/Password";
			loginView.addObject("message", message);
			return loginView;
		}

	}
	
	@RequestMapping(value = "/OTPlogin", method = RequestMethod.POST)
	public ModelAndView OTPLogin(@RequestParam("otplogin") String otpEntered, @RequestParam("emailcopy") String emailID,
			 HttpSession session) {
		ModelAndView loginView = new ModelAndView("index");
		ModelAndView homeModel = new ModelAndView("home");
		System.out.println("Email is"+emailID);
		User user = service.getUserByEmailID(emailID);
		
		String s = Integer.toString(otpLoginSent);
		if (otpEntered.equals(s)){
			SessionManager.setSessionAttributes(session.getId(), user);
			homeModel.addObject("user",user);
			return homeModel;
		}
		else{
			String message="Invalid OTP";
			loginView.addObject("message", message);
			return loginView;
		}
			
		
	}
	
	@RequestMapping(value =  "/",  method = RequestMethod.GET)
	public ModelAndView getLogin(HttpSession session) {
		ModelAndView loginView = new ModelAndView("index");
		String message = "";
		String hideOrUnhideOTPBlock = "none";
		loginView.addObject("hideOrUnhideOTPBlock", hideOrUnhideOTPBlock );
		loginView.addObject("message", message );
		
			return loginView;
	}
	
	
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public ModelAndView editProfile(ModelMap model, HttpServletRequest request) {

		return new ModelAndView("forgotPassword");
	}

	@RequestMapping(value =  "/logoutSuccess" , method = RequestMethod.GET)
	public ModelAndView logoutSuccess(HttpSession httpSession) {
		SessionManager.removeActiveUser(httpSession.getId());
		httpSession.invalidate();
		
		return new ModelAndView("logoutSuccess");

	}
	/* 
	 * For Login Recovery, function to Load the User's Security Questions
	 * */
	@ResponseBody
	@RequestMapping(value = "/fetchSecQuesWithName", method = RequestMethod.POST)
	public String fetchSecQuesWithName(@RequestParam("json1") String firstName,
			@RequestParam("json2") String lastName, HttpSession httpSession) {

		String message = "You do not have an account on FriendHub";
		String securityQuestion = service.getSecQuesByName(firstName, lastName);
		if (securityQuestion != null) {

			return securityQuestion;
		}

		else
			return message;

	}
	
	/* 
	 * For Login Recover, function to Load User's Security Question- When Name Forgotten
	 * */
	@ResponseBody
	@RequestMapping(value =  "/fetchSecQuesWithEmail", method = RequestMethod.POST)
	public String fetchSecQuesWithEmail(@RequestParam("json") String emailID,
			HttpSession httpSession) {
		String message = "You do not have an account on FriendHub";
		String securityQuestion = service.getSecQuesByEmail(emailID);
		if (securityQuestion != null) {

			return securityQuestion;
		}

		else
			return message;
	}
	/* 
	 * A function to first Validate the Existence of User's Email before fetching Security Questions
	 * */	

	@RequestMapping(value = { "/forgotLogin" }, method = RequestMethod.POST)
	public ModelAndView forgotLogin(@RequestParam("email") String emailID,HttpSession session,
			@RequestParam("secAns") String secAns,
			@RequestParam("fname") String fname,
			@RequestParam("lname") String lname) {
		System.out.println("In Fetch function" + emailID);
		if (fname != null) { 
			String fetchedEmail;
			fetchedEmail = service.getEmailByName(fname, lname);
			if (fetchedEmail != null)
				emailID = fetchedEmail;
			else{
				System.out.println("Email not found");
				
			}

		}
		String securityAnswer;
		String sender = "hubbmate@gmail.com";

		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory b = new XmlBeanFactory(r); 
		EmailHelper m = (EmailHelper) b.getBean("emailHelper");
		System.out.println("Fetching security Answer");
		User user = service.getUserByEmailID(emailID);
		securityAnswer = service.getSecAnsByEmail(emailID);
		if (secAns.equals(securityAnswer)) {

			
			ModelAndView homeModel = new ModelAndView("home");
			System.out.println("Returning to home");
		
														
			String receiver = emailID;
			m.sendMail(sender, receiver, "Your FriendHub Account Activity Update:", //Sent Email to User Notifying the Login Recovery
					" Login Recovery was performed.");
			SessionManager.setSessionAttributes(session.getId(), user);
			homeModel.addObject("user", user);
			return homeModel;
		} else {
			
														
			String receiver = emailID;
			m.sendMail(sender, receiver, "Your FriendHub Account Activity Update:",
					" Answer to Security Question during Login Recovery was Incorrect");//Sent Email to User Notifying possible Account Hacks
			
			return new ModelAndView("accountBlocked");
		}

	}

	@RequestMapping("*")
	public ModelAndView hello(HttpServletRequest request) {
		
		ModelAndView loginView = new ModelAndView("index");
		String message = "";
		String hideOrUnhideOTPBlock = "none";
		loginView.addObject("hideOrUnhideOTPBlock", hideOrUnhideOTPBlock );
		loginView.addObject("message", message );
		
			return loginView;
			
			
	}
	
	 @RequestMapping(value = "/getUserProfile", method = RequestMethod.POST)
		public ModelAndView getUserProfile(
				@RequestParam(value = "userIdField") String userId,
				HttpSession httpSession) {

			User friendUser = service.getUserByID(Integer.parseInt(userId));
			ModelAndView friendView = new ModelAndView("friendUserView");
			friendView.addObject("friendUser", friendUser);
			return friendView;
		}
		
		@RequestMapping(value = "/getSearchedProfile", method = RequestMethod.POST)
		@ResponseBody
		public User getSearchedProfile(
				@RequestParam(value = "text") String searchedName, ModelMap model,
				HttpSession httpSession) {

			User friendUser = service.getUserByFirstName(searchedName);
			
			return friendUser;

		}

}
