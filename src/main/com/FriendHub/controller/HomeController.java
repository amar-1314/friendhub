package main.com.FriendHub.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import main.com.FriendHub.Utilities.ProfilePicture;
import main.com.FriendHub.Utilities.SessionManager;
import main.com.FriendHub.compositekeys.StatusUpdateLikeDisLikeKeys;
import main.com.FriendHub.model.Comments;
import main.com.FriendHub.model.StatusUpdate;
import main.com.FriendHub.model.StatusUpdateLikeDislikeCount;
import main.com.FriendHub.model.User;
import main.com.FriendHub.service.NewsFeedService;
import main.com.FriendHub.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private NewsFeedService newsFeedService;

	@RequestMapping(value =  "/home" , method = RequestMethod.POST)
	public ModelAndView home(Model model, HttpSession httpSession) {
		ProfilePicture pic = new ProfilePicture();
		User user = SessionManager.getCurrentUser(httpSession.getId());
		user= userService.getUserByEmailID(user.getEmailID());
		List<StatusUpdate> statusUpdateList = newsFeedService
				.getStatusUpdates(user);
		String ProfilePictureString = pic.getProfilePictureByteArray(user.getProfilePicture());
		ModelAndView homeModel = new ModelAndView("home");
		homeModel.addObject("statusUpdates", statusUpdateList);
		homeModel.addObject("user", user);
		homeModel.addObject("ProfilePictureString", ProfilePictureString);

		return homeModel;
	}
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public ModelAndView getHomePage(Model model, HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		user= userService.getUserByEmailID(user.getEmailID());
		List<StatusUpdate> statusUpdateList = newsFeedService.getStatusUpdates(user);
		ModelAndView homeModel = new ModelAndView("home");

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
			
			return homeModel;
		}
		else {
			return homeModel;
		}
	}
	
	@RequestMapping(value = "/familyUpdates" , method = RequestMethod.GET)
	public ModelAndView getFamily(Model model, HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		user= userService.getUserByEmailID(user.getEmailID());
		List<StatusUpdate> statusUpdateList = newsFeedService.getStatusUpdatesByCateogry(user,2);
		ModelAndView homeModel = new ModelAndView("home");

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
			
			return homeModel;
		}
		else {
			return homeModel;
		}
	}
	
	@RequestMapping(value = "/educationUpdates" , method = RequestMethod.GET)
	public ModelAndView getEducationUpdates(Model model, HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		user= userService.getUserByEmailID(user.getEmailID());
		List<StatusUpdate> statusUpdateList = newsFeedService.getStatusUpdatesByCateogry(user,3);
		ModelAndView homeModel = new ModelAndView("home");

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
			
			return homeModel;
		}
		else {
			return homeModel;
		}
	}
	
	@RequestMapping(value = "/workUpdates" , method = RequestMethod.GET)
	public ModelAndView getWorkUpdates(Model model, HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		user= userService.getUserByEmailID(user.getEmailID());
		List<StatusUpdate> statusUpdateList = newsFeedService.getStatusUpdatesByCateogry(user,4);
		ModelAndView homeModel = new ModelAndView("home");

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
			
			return homeModel;
		}
		else {
			return homeModel;
		}
	}
	
	
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public @ResponseBody String updateStatus(@RequestParam(value = "text") String status,HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		StatusUpdate statusUpdate = new StatusUpdate(status, user);
		newsFeedService.updateStatus(statusUpdate);
		return  "success";
	}
	
	@RequestMapping(value = "/updateComment", method = RequestMethod.POST)
	public @ResponseBody String updateComment(@RequestParam(value = "text") String comment,@RequestParam(value = "statusUpdateID") String statusUpdateId, HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		StatusUpdate statusUpdate = newsFeedService.getStatusByID(Integer.parseInt(statusUpdateId));
		newsFeedService.updateComment(statusUpdate,user,comment);
		return  "success";
	}
	

	@RequestMapping(value = "/updateLikeTable", method = RequestMethod.POST)
	public @ResponseBody String updateLikeTable(@RequestParam(value = "statusUpdateID") String statusUpdateID,@RequestParam(value = "flagVal") String flagVal,HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		StatusUpdate statusUpdate = newsFeedService.getStatusByID(Integer.parseInt(statusUpdateID));
		StatusUpdateLikeDislikeCount statusUpdateLikeDislikeCount = new StatusUpdateLikeDislikeCount();
		StatusUpdateLikeDisLikeKeys statusUpdateLikeDisLikeKeys = new StatusUpdateLikeDisLikeKeys(statusUpdate,user);
		statusUpdateLikeDislikeCount.setStatusUpdateLikeDisLikeKeys(statusUpdateLikeDisLikeKeys);
		statusUpdateLikeDislikeCount.setLikeOrDisLikeFlag(Integer.parseInt(flagVal));
		//newsFeedService.updateLikeOrDisLikeTotalCount(statusUpdate,Integer.parseInt(flagVal));
		newsFeedService.updateLikeDisLikeCounterTable(statusUpdateLikeDislikeCount);
		return  "success";
	}

}
