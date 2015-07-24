package main.com.FriendHub.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import main.com.FriendHub.Utilities.SessionManager;
import main.com.FriendHub.model.FriendList;
import main.com.FriendHub.model.User;
import main.com.FriendHub.service.FriendListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkContactsController {

	@Autowired
	FriendListService service;

	@RequestMapping(value = "/work", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listWorkFriends(ModelMap model, HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());

		List<FriendList> workFriendList = service.getFriendListByCategory(user,
				2);
		ModelAndView workView = new ModelAndView("work");
		workView.addObject("workFriendList", workFriendList);
		workView.addObject("user", user);
		return workView;
	}

	@RequestMapping(value = "/education", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listEduFriends(ModelMap model, HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());
			
		List<FriendList> eduFriendList = service.getFriendListByCategory(user,
				3);
		ModelAndView eduView = new ModelAndView("education");
		eduView.addObject("eduFriendList", eduFriendList);
		eduView.addObject("user", user);

		return eduView;
	}

	@RequestMapping(value = "/family", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listFamilyFriends(ModelMap model,
			HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());

		List<FriendList> familyFriendList = service.getFriendListByCategory(
				user, 4);
		ModelAndView familyView = new ModelAndView("family");
		familyView.addObject("familyFriendList", familyFriendList);
		familyView.addObject("user", user);

		return familyView;
	}

	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView listFriends(ModelMap model, HttpSession httpSession) {

		User user = SessionManager.getCurrentUser(httpSession.getId());

		List<FriendList> friendFriendList = service.getFriendListByCategory(
				user, 1);
		ModelAndView friendView = new ModelAndView("friends");
		friendView.addObject("friendFriendList", friendFriendList);
		friendView.addObject("user", user);
		return friendView;
	}

}
