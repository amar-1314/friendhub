
package main.com.FriendHub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.com.FriendHub.Utilities.EmailHelper;
import main.com.FriendHub.Utilities.SessionManager;
import main.com.FriendHub.model.PrivacySettings;
import main.com.FriendHub.model.User;
import main.com.FriendHub.service.UserService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SuppressWarnings("deprecation")
@Controller
@SessionAttributes("sid")
public class SettingsController {
	@Autowired
	UserService service;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	/*
	 * Load User's Account Settings
	 * */
	@RequestMapping(value = "/accountSettings", method = RequestMethod.GET)
	public ModelAndView accountSettings(HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		user=service.getUserByEmailID(user.getEmailID());
		ModelAndView accView = new ModelAndView("accountSettings");
		
		accView.addObject("updateAccSettings", user);
		return accView;
	}
	
	/*
	 * Set the User's Privacy Settings
	 * */
	@RequestMapping(value = "/prvcySettings", method = RequestMethod.POST)
	public ModelAndView setPrivSet(@ModelAttribute PrivacySettings updatePvcySettings ,HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		int thisUserID=user.getUserID();
		System.out.println("In controller pvc"+thisUserID);
		ModelAndView home = new ModelAndView("home");
		home.addObject("user",user);
		service.setPrivSet(thisUserID,updatePvcySettings);

		return home;
	}
	/*
	 * Load User's Privacy Settings
	 * */
	@RequestMapping(value = "/prvcySettings", method = RequestMethod.GET)
	public ModelAndView prvcySettings(ModelMap model, HttpServletRequest request,
			HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		int thisUserID=user.getUserID();
		System.out.println("in controller pvcy"+thisUserID);
		ModelAndView pvcyView= new ModelAndView("privacySettings");
		PrivacySettings ps=service.getUserPvcySettings(thisUserID);
		pvcyView.addObject("user", user);
		pvcyView.addObject("updatePvcySettings", ps);
		/*	User updateAccSettings = SessionManager.getCurrentUser(httpSession
				.getId());*/
		/*User updateAccSettings = service.getUserByEmailID("vineetasweety@gmail.com");
		System.out.println(updateAccSettings.getSecurityAnswer());
		System.out.println(updateAccSettings.getSecurityQuestion());
		model.addAttribute("updateAccSettings", updateAccSettings);*/
		return pvcyView;
	}
	/*
	 * Return to Home Page after Account Settings
	 * */
	@RequestMapping(value = "/getHome", method = RequestMethod.POST)
	public ModelAndView getHome(ModelMap model, HttpServletRequest request,
			HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		ModelAndView home = new ModelAndView("home");
		home.addObject("user",user);
		return home;
	}
	/*
	 * Update User's Security Question and Answer
	 * */
	@ResponseBody
	@RequestMapping(value = {"/updateSecQuesAns"}, method = RequestMethod.POST)
	public String updateSecQuesAns(@RequestParam("json1") String secQues, @RequestParam("json2") String secAns,@RequestParam("json3") String emailID, HttpSession httpSession) {
		//String message="Could not update";
		System.out.println(emailID+secQues+secAns+"In Controller");
		String updateSecQaStatus=service.updateSecQuesAnsWithEmail(secQues,secAns,emailID);
		if(updateSecQaStatus=="success")


			return "success";
		else
			return "failed";

	}
	/*
	 * Deactivate the User
	 */
	@ResponseBody
	@RequestMapping(value = {"/deactivateUserWithEmail"}, method = RequestMethod.POST)
	public String deactivateUserWithEmail(@RequestParam("json1") String emailID) {
		String deactivateStatus=service.deactivateUserWithEmail(emailID);
		if(deactivateStatus=="success")
			return "success";
		else
			return "failed";
	}
	/*
	 * Delete User's Account
	 * */
	@ResponseBody
	@RequestMapping(value = {"/deleteUserWithEmail"}, method = RequestMethod.POST)
	public String deleteUserWithEmail(@RequestParam("json1") String emailID) {
		String deleteStatus=service.deleteUserWithEmail(emailID);
		if(deleteStatus=="success")
			return "success";
		else
			return "failed";
	}
	/*
	 * Enable User's Two Factor Authentication Setting
	 * */
	@ResponseBody
	@RequestMapping(value = {"/updateTwoFactorWithEmail"}, method = RequestMethod.POST)
	public String updateTwoFactorWithEmail(@RequestParam("json1") String emailID) {
		String updateTwoFacStatus=service.updateTwoFactorWithEmail(emailID);
		if(updateTwoFacStatus=="success")
			return "success";
		else
			return "failed";
	}
	/*
	 * Disable User's Two Factor Authentication Setting
	 * */
	@ResponseBody
	@RequestMapping(value = {"/disableTwoFactorWithEmail"}, method = RequestMethod.POST)
	public String disableTwoFactorWithEmail(@RequestParam("json1") String emailID) {
		String updateTwoFacStatus=service.disableTwoFactorWithEmail(emailID);
		if(updateTwoFacStatus=="success")
			return "success";
		else
			return "failed";
	}
	/* 
	 * Verify User's Current Password Before Changing Password Step
	 * */
	@ResponseBody
	@RequestMapping(value = {"/verifyPassword"}, method = RequestMethod.POST)
	public String verifyPassword(@RequestParam("json1") String emailID,@RequestParam("json2") String currPwd) {
		User user = service.getUserByEmailID(emailID);
		if (passwordEncoder.matches(currPwd, user.getPassword()))
			return "verified";
		else
			return "Failure";

	}
	/* 
	 * Update User's New Password
	 * */
	@ResponseBody
	@RequestMapping(value = {"/updatePassword"}, method = RequestMethod.POST)
	public String updatePassword(@RequestParam("json1") String emailID,@RequestParam("json2") String pwd) {
		String encodedPwd=passwordEncoder.encode(pwd);
		String updatePwdStatus=service.updatePassword(encodedPwd,emailID);

		if(updatePwdStatus=="success")	{		
			String sender = "hubbmate@gmail.com";// write here sender gmail

			Resource r = new ClassPathResource("applicationContext.xml");
			BeanFactory b = new XmlBeanFactory(r); /*
			 * new FileSystemResource(
			 * "rest-servlet.xml")
			 */
			EmailHelper m = (EmailHelper) b.getBean("emailHelper");
			String receiver = emailID;// write here receiver id
			m.sendMail(sender, receiver, "Your FriendHub Account Activity Update:",
					" Password Change was performed");
			return "success";
		}
		else
			return "failure";
	}
}