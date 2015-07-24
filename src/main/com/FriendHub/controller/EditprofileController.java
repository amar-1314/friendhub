package main.com.FriendHub.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.com.FriendHub.Utilities.SessionManager;
import main.com.FriendHub.model.EducationProfile;
import main.com.FriendHub.model.User;
import main.com.FriendHub.model.WorkProfile;
import main.com.FriendHub.service.EducationProfileService;
import main.com.FriendHub.service.UserService;
import main.com.FriendHub.service.WorkProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditprofileController {

	@Autowired
	UserService service;

	@Autowired
	WorkProfileService workProfileService;

	@Autowired
	EducationProfileService educationProfileService;


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/uploadPictures", method = RequestMethod.GET)
	public ModelAndView uploadPictures(ModelMap model,
			HttpServletRequest request, HttpSession httpSession) {

		User uploadPicture = SessionManager.getCurrentUser(httpSession.getId());
		System.out.println(uploadPicture.getState()
				+ "I am in profilepicture method");
		model.addAttribute("uploadPicture", uploadPicture);

		/*
		 * String base64Encoded = ""; ByteArrayOutputStream baos = new
		 * ByteArrayOutputStream(); byte[] buf = new byte[1024]; Blob blob =
		 * editProfileForm.getProfilePicture(); InputStream in = null; try { in
		 * = blob.getBinaryStream(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * System.out.println("id content" +in); int n = 0; try { while
		 * ((n=in.read(buf))>=0) { baos.write(buf, 0, n);
		 * 
		 * } } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * try { in.close(); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } byte[] bytes = baos.toByteArray();
		 * System.out.println("bytes" +bytes); // byte[] encodeBase64 =
		 * Base64.encodeBase64(buf); try { base64Encoded = new String(bytes,
		 * "UTF-8"); } catch (UnsupportedEncodingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * editProfileForm.setAddressLine2
		 * ("data:image/jpeg;base64,"+base64Encoded);
		 * model.addAttribute("editProfileForm", editProfileForm);
		 */
		return new ModelAndView("uploadPictures"); // new
													// ModelAndView("editProfile");
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public ModelAndView editProfile(ModelMap model, HttpServletRequest request,
			HttpSession httpSession) {

		User editProfileForm = SessionManager.getCurrentUser(httpSession
				.getId());
		User user = service.getUserByEmailID(editProfileForm.getEmailID());
		 ModelAndView editProfileView = new ModelAndView("editProfile");
		 editProfileView.addObject("user", user);
		 editProfileView.addObject("editProfileForm", editProfileForm);
		return editProfileView; 
	}

	@RequestMapping(value = "/editProfile" , method = RequestMethod.POST)
	public ModelAndView editProfile(@ModelAttribute User user,
			Model model,HttpSession httpSession) {
		service.saveUserProfile(user);
		// model.addAttribute("firstName", "tester");
		ModelAndView homeModel = new ModelAndView("home");
		user = SessionManager.getCurrentUser(httpSession.getId());
		homeModel.addObject("user", user);
		return homeModel;
	}

	@RequestMapping(value = "/basicDetails", method = RequestMethod.GET)
	public ModelAndView basicDetails(ModelMap model, HttpServletRequest request) {

		return new ModelAndView("editProfile");
	}

	@RequestMapping(value = "/workDetails", method = RequestMethod.GET)
	public ModelAndView workDetails(ModelMap model, HttpServletRequest request,
			HttpSession httpSession) {
		List<WorkProfile> workDetailsList = workProfileService
				.findAllWorkProfiles(SessionManager.getCurrentUser(httpSession
						.getId()));
		User userId = SessionManager.getCurrentUser(httpSession
				.getId());
		ModelAndView workDetailsView = new ModelAndView("workDetails");
		workDetailsView.addObject("workDetailsList", workDetailsList);
		workDetailsView.addObject("userId", userId);
		return workDetailsView;
	}

	@RequestMapping(value = "/educationDetails", method = RequestMethod.GET)
	public ModelAndView educationDetails(ModelMap model,
			HttpServletRequest request, HttpSession httpSession) {
		List<EducationProfile> educationDetailsList = educationProfileService
				.findAllEducationProfiles(SessionManager
						.getCurrentUser(httpSession.getId()));
		ModelAndView educationDetailsView = new ModelAndView("educationDetails");
		educationDetailsView.addObject("educationDetailsList",
				educationDetailsList);
		return educationDetailsView;
	}

	@RequestMapping(value = "/profilePicture", method = RequestMethod.GET)
	public ModelAndView profilePicture(ModelMap model,
			HttpServletRequest request, HttpSession httpSession) {

		User editProfilePicture = SessionManager.getCurrentUser(httpSession
				.getId());
		model.addAttribute("editProfilePicture", editProfilePicture);
		return new ModelAndView("profilePicture");
	}

	@RequestMapping(value = { "/profilePicture" }, method = RequestMethod.POST)
	public ModelAndView profilePicture(
			@ModelAttribute("editProfilePicture") User user,
			@RequestParam("file") MultipartFile file, HttpSession httpSession) {
		User editProfilePicture = SessionManager.getCurrentUser(httpSession
				.getId());

		service.saveProfilePicture(editProfilePicture, file);
		user= service.getUserByEmailID(editProfilePicture.getEmailID());
		return new ModelAndView("home","user",user );
	}

	@ResponseBody
	@RequestMapping(value = "/updateWorkDetails", method = RequestMethod.POST)
	public ModelAndView updateWorkDetails(
			@RequestParam(value = "work_ProfileID") String work_ProfileID,
			@RequestParam(value = "userID") String userID,
			@RequestParam(value = "companyName") String companyName,
			@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate,
			HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date contractEndDate = null;
		java.util.Date contractToEndDate = null;
		java.sql.Date sqlWorkFromDate = null;
		java.sql.Date sqlWorkToDate = null;
		try {
		     contractEndDate = simpleDateFormat.parse(fromDate);
		     sqlWorkFromDate = new java.sql.Date(contractEndDate.getTime());
		     contractToEndDate = simpleDateFormat.parse(toDate);
		     sqlWorkToDate = new java.sql.Date(contractToEndDate.getTime());
		} catch (ParseException e) {
		    // handle telling the user they have bad input
		}
		
		System.out.println("the date is" + sqlWorkFromDate);
		

		WorkProfile workprofile = new WorkProfile(
				Integer.parseInt(work_ProfileID), user, companyName, sqlWorkFromDate,
				sqlWorkToDate);
		
		workProfileService.addWorkDetails(workprofile);

		return new ModelAndView("workDetails");
	}
	@ResponseBody
	@RequestMapping(value = "/addWorkDetails", method = RequestMethod.POST)
	public ModelAndView addWorkDetails(
			@RequestParam(value = "companyName") String companyName,
			@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate,
			HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date contractEndDate = null;
		java.util.Date contractToEndDate = null;
		java.sql.Date sqlWorkFromDate = null;
		java.sql.Date sqlWorkToDate = null;
		try {
		     contractEndDate = simpleDateFormat.parse(fromDate);
		     sqlWorkFromDate = new java.sql.Date(contractEndDate.getTime());
		     contractToEndDate = simpleDateFormat.parse(toDate);
		     sqlWorkToDate = new java.sql.Date(contractToEndDate.getTime());
		} catch (ParseException e) {
		    // handle telling the user they have bad input
		}
		
		System.out.println("the date in add work details" + sqlWorkFromDate);
		System.out.println("the company in add work details" + companyName);
		System.out.println("the user id is" + user);
		WorkProfile workprofile = new WorkProfile(user, companyName, sqlWorkFromDate,sqlWorkToDate);
		
		workProfileService.addWorkDetails(workprofile);

		return new ModelAndView("workDetails");
	}
	
	@ResponseBody
	@RequestMapping(value = "/addEducationDetails", method = RequestMethod.POST)
	public ModelAndView addEducationDetails(
			@RequestParam(value = "education_profile_ID") String education_profile_ID,
			@RequestParam(value = "userID") String userID,
			@RequestParam(value = "collegeName") String collegename,
			@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate,
			HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date contractEndDate = null;
		java.util.Date contractToEndDate = null;
		java.sql.Date sqlWorkFromDate = null;
		java.sql.Date sqlWorkToDate = null;
		try {
		     contractEndDate = simpleDateFormat.parse(fromDate);
		     sqlWorkFromDate = new java.sql.Date(contractEndDate.getTime());
		     contractToEndDate = simpleDateFormat.parse(toDate);
		     sqlWorkToDate = new java.sql.Date(contractToEndDate.getTime());
		} catch (ParseException e) {
		    // handle telling the user they have bad input
		}
		
		System.out.println("the date is" + sqlWorkFromDate);
		

		EducationProfile educationprofile = new EducationProfile(
				Integer.parseInt(education_profile_ID), user, collegename, sqlWorkFromDate,
				sqlWorkToDate);
		
		educationProfileService.addEducationDetails(educationprofile);

		return new ModelAndView("educationDetails");
	}
	
	@ResponseBody
	@RequestMapping(value = "/addNewEducationDetails", method = RequestMethod.POST)
	public ModelAndView addNewEducationDetails(
			
			@RequestParam(value = "collegeName") String collegename,
			@RequestParam(value = "fromDate") String fromDate,
			@RequestParam(value = "toDate") String toDate,
			HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date contractEndDate = null;
		java.util.Date contractToEndDate = null;
		java.sql.Date sqlWorkFromDate = null;
		java.sql.Date sqlWorkToDate = null;
		try {
		     contractEndDate = simpleDateFormat.parse(fromDate);
		     sqlWorkFromDate = new java.sql.Date(contractEndDate.getTime());
		     contractToEndDate = simpleDateFormat.parse(toDate);
		     sqlWorkToDate = new java.sql.Date(contractToEndDate.getTime());
		} catch (ParseException e) {
		    // handle telling the user they have bad input
		}
		
		System.out.println("the date is" + sqlWorkFromDate);
		

		EducationProfile educationprofile = new EducationProfile( user, collegename, sqlWorkFromDate,
				sqlWorkToDate);
		
		educationProfileService.addEducationDetails(educationprofile);

		return new ModelAndView("educationDetails");
	}
	
	 @RequestMapping(value =  "/educationProfile" , method = RequestMethod.GET)
	    public String listEducationProfiles(ModelMap model) {
	 
	        List<EducationProfile> educationProfile = educationProfileService.findAllEducationProfiles(null);
	        model.addAttribute("educationProfile", educationProfile);
	        return "educationProfile";
	    }
	 
	   
	    /*
	     * 
	     */
	    @RequestMapping(value =  "/workProfile" , method = RequestMethod.GET)
	    public String listWorkProfiles(ModelMap model) {
	 
	        List<WorkProfile> workProfile = workProfileService.findAllWorkProfiles(null);
	        model.addAttribute("workProfile", workProfile);
	        return "workProfile";
	    }
	    
}
