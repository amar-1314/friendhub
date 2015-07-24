package main.com.FriendHub.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.com.FriendHub.Utilities.EmailHelper;
import main.com.FriendHub.Utilities.SessionManager;
import main.com.FriendHub.model.User;
import main.com.FriendHub.service.UserService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("deprecation")
@Controller
public class SignUpController {

	@Autowired
	UserService service;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	int currOTP;
	/* 
	 * Load Sign Up Form
	 * */
	@RequestMapping(value = "/signUp" , method = RequestMethod.GET)
	public ModelAndView signUpGet(@ModelAttribute User user, Model model) {

		User userSignUpForm = new User();
		model.addAttribute("userSignUpForm", userSignUpForm);

		return new ModelAndView("signUp");
	}
	/* 
	 * Save The User Account in Database
	 * */
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ModelAndView signUp(@ModelAttribute User user, Model model,HttpSession session) {
		SessionManager.setSessionAttributes(session.getId(), user);
		/*String thisEmail=user.getEmailID();*/
		try{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActiveFlag(1);
		service.registerUser(user);
		}
		catch(Exception e){						/* Catch a HQL Exception when Email Already Exists since Email is Primary Key */
			System.out.println("Email In Use");
			return new ModelAndView("emailExists");
			
		}

		return new ModelAndView("home");
	}
	/* 
	 * Sent OTP to User's Email Address for Verification
	 * */
	@ResponseBody
	@RequestMapping(value = "/sendOTP", method = RequestMethod.POST)
	public String sendOTP(@RequestParam("json") String emailID) {
		// verify if email already exists
		/*String pwd = service.getUserByEmail(emailID);
		if (pwd == null) {
		User emailUsedStatus=service.getNameByEmailID(emailID);
			System.out.println(emailUsedStatus);	*/
		// email logic
			/*if(emailUsedStatus==null){*/
		try{
			System.out.println("In Controller");
			Random rnd = new Random();
			currOTP = 100000 + rnd.nextInt(900000);
			System.out.println("random number" + currOTP);
			Resource r = new ClassPathResource("applicationContext.xml");
			BeanFactory b = new XmlBeanFactory(r); /*
													 * new FileSystemResource(
													 * "rest-servlet.xml")
													 */
			EmailHelper m = (EmailHelper) b.getBean("emailHelper");
			String sender = "hubbmate@gmail.com";// write here sender gmail
														// id
			String receiver = emailID;// write here receiver id
			m.sendMail(sender, receiver, "OTP for your FriendHub Account",
					"Dear FriendHub user,\n\nTo verify your email, please enter this random number on the sign-up page "+Integer.toString(currOTP)+"\n\n\n Thanks,\nFriendHub Team.");
			return "success";
		
		}/*Exception Where Email is Left Blank*/
		catch(Exception e)
		{
			System.out.println(e);
			return "Email Empty";
		}
		
		/*} else {
			System.out.println("Email already exists");
			return "failure";
		}*/
	}
	/* 
	 * Verify the OTP sent with the OTP Entered
	 * */
	@ResponseBody
	@RequestMapping(value = "/otpVerification", method = RequestMethod.POST)
	public String otpVerification(@RequestParam("json") String otp) {
		System.out.println(otp);
		String s = Integer.toString(currOTP);
		if (otp.equals(s))
			return "success";
		else
			return "failure";
	}
	/* 
	 * End User's Session Upon Logout
	 * */
	@RequestMapping(value = "/logoutSuccess" , method = RequestMethod.POST)
	public ModelAndView logout(ModelMap model, HttpServletRequest request,
			HttpSession httpSession) {
		httpSession.invalidate();
		httpSession.removeAttribute("sessionId");
		return new ModelAndView("index");
	}

	/*@RequestMapping(value =  "/prvcySettings", method = RequestMethod.POST)
	public ModelAndView loadPrivacySettings(ModelMap model,
			HttpServletRequest request) {

		return new ModelAndView("privacySettings");
	}*/

}