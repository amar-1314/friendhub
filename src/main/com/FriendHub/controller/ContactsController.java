package main.com.FriendHub.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import main.com.FriendHub.Utilities.SessionManager;
import main.com.FriendHub.model.FriendList;
import main.com.FriendHub.model.User;
import main.com.FriendHub.service.FriendListService;
import main.com.FriendHub.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactsController {

	@Autowired
	FriendListService service;

	@Autowired
	UserService userService;
	public int showVal=0;
	String searchedFriendUser;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listFriends(ModelMap model, HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());

		
		
		List<FriendList> friendList = service.getFriendList(user);
		Map<String, User> friendNameUserMap = new HashMap<String, User>();
		List<String> friendNames = new ArrayList<String>();
		List<Integer> friendCount = new ArrayList<Integer>();
		for (FriendList friend : friendList) {
			friendNameUserMap.put(friend.getFriendUserID().getFirstName(),
					friend.getFriendUserID());
			friendNames.add(friend.getFriendUserID().getFirstName());
		}
		
		for (FriendList friend : friendList) {
		
			friendCount.add(service.getFriendCount(friend.getFriendUserID()));
		}
		
		
		
		
		
		ModelAndView contactsView = new ModelAndView("contacts");
		contactsView.addObject("user", user);
		contactsView.addObject("friendList", friendList);
		contactsView.addObject("friendNames", friendNames);
		contactsView.addObject("friendNameUserMap", friendNameUserMap);
		contactsView.addObject("friendCount", friendCount);
		return contactsView;
	}

	@RequestMapping(value = "/getFriendList", method = RequestMethod.POST)
	@ResponseBody
	public String getFriendList(@RequestParam(value = "text") String friendName,
			ModelMap model, HttpSession httpSession) {

		searchedFriendUser = friendName;
		User friendSearchedUser = userService.getUserByFirstName(friendName);
		
		if(friendSearchedUser == null)
		{
			friendName="";
		}
		return friendName;
	}

	
	@RequestMapping(value = "/getFriendProfile", method = RequestMethod.POST)
	public ModelAndView getFriendProfile(
			@RequestParam(value = "userIdField") String userId,
			HttpSession httpSession) {

		User friendUser = userService.getUserByID(Integer.parseInt(userId));
		
		User user = SessionManager.getCurrentUser(httpSession.getId());
		
		List<User> u = service.checkFriends(SessionManager.getCurrentUser(httpSession.getId()), friendUser);
		
		
		ModelAndView friendView = new ModelAndView("friendUserView");
		friendView.addObject("friendUser", friendUser);
		int s = u.size();
		if(s == 0)
		{
			showVal = 1;
		}
		else
		{
			showVal = 0;
		}
		friendView.addObject("showVal",showVal);
		friendView.addObject("user", user);
		
		return friendView;
	}

	@RequestMapping(value = "/allusers", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView allusers( ModelMap model,
			HttpSession httpSession) {
		
		List<User> alluserlist = userService.getAllUserList();
		
		ModelAndView usersView = new ModelAndView("allusers");
		usersView.addObject("alluserlist", alluserlist);
		
		return usersView;

	}
	@RequestMapping(value = {"/adduser"}, method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView adduser(@RequestParam("userID") String userID,HttpServletRequest request,	
			HttpSession httpSession) {
		
		if(showVal == 1)
		{
		User friendUser = userService.getUserByID(Integer.parseInt(userID));
		FriendList friend = new FriendList();
		
			String[] val = request.getParameterValues("itemCategory");
		int categ = Integer.parseInt(val[0]);
		friend.setUserID(SessionManager.getCurrentUser(httpSession.getId()));
		friend.setFriendUserID(friendUser);
		friend.setCategoryID(categ);
		friend.setRequestStatus('Y');
		
		service.addFriend(friend);
		}
		else
		{
			User friendUser = userService.getUserByID(Integer.parseInt(userID));
			
			service.unfriend(friendUser);
			showVal = 1;
		}
		User user = SessionManager.getCurrentUser(httpSession.getId());
		ModelAndView homeView = new ModelAndView("home");
		homeView.addObject("user",user);
		return homeView;
	}

	 @RequestMapping(value = "/adduser", method = RequestMethod.GET)
	 
	 public ModelAndView profilePicture(ModelMap model, HttpServletRequest request,HttpSession httpSession) {
			
		User addFriendForm = SessionManager.getCurrentUser(httpSession.getId());
		ModelAndView addUserView = new ModelAndView("friendUserView");
		addUserView.addObject("addFriendForm", addFriendForm);
			return addUserView;  
		}
	
		@RequestMapping(value = "/getAllUserList", method = RequestMethod.POST)
		@ResponseBody
		public List<String> getAllUserList(@RequestParam(value = "text") String var,ModelMap model, HttpSession httpSession) {

			List<User> friendSearchedUser = userService.getAllUserList();
			User currUser = SessionManager.getCurrentUser(httpSession.getId());
			String currUserFirstName = currUser.getFirstName();
			List<String> firstNameList = new ArrayList<String>();
			
			for(User eachUser: friendSearchedUser)
			{
				String eachUserFirstName = eachUser.getFirstName();
				if(!currUserFirstName.equals(eachUserFirstName))
				{
				firstNameList.add(eachUserFirstName);
				}
				}
			return firstNameList;
		}
	

		 @RequestMapping(value = "/getSearchedFriend", method = RequestMethod.GET)
		 
		 public ModelAndView searchFriend(ModelMap model, HttpServletRequest request,HttpSession httpSession) {
				
			 showVal = 0;
			User friendUser = userService.getUserByFirstName(searchedFriendUser);
		
			ModelAndView addUserView = new ModelAndView("friendUserView");
			addUserView.addObject("friendUser", friendUser);
			addUserView.addObject("showVal",showVal);
				return addUserView;  
			}
		 
 @RequestMapping(value = "/getSearchedUser", method = RequestMethod.GET)
		 
		 public ModelAndView searchUser(ModelMap model, HttpServletRequest request,HttpSession httpSession) {
				
			 showVal = 0;
			User friendUser = userService.getUserByFirstName(searchedFriendUser);
			List<User> u = service.checkFriends(SessionManager.getCurrentUser(httpSession.getId()), friendUser);
			ModelAndView addUserView = new ModelAndView("friendUserView");
			int s = u.size();
			if(s == 0)
			{
				showVal = 1;
			}
			else
			{
				showVal = 0;
			}
			
			
			User user = SessionManager.getCurrentUser(httpSession.getId());
			addUserView.addObject("user",user);
			
			addUserView.addObject("friendUser", friendUser);
			addUserView.addObject("showVal",showVal);
				return addUserView;  
			}
		
}
