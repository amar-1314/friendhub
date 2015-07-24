package main.com.FriendHub.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.com.FriendHub.Utilities.GroupedMessageNotifications;
import main.com.FriendHub.Utilities.SessionManager;
import main.com.FriendHub.model.Attachments;
import main.com.FriendHub.model.FriendList;
import main.com.FriendHub.model.MessageNotifications;
import main.com.FriendHub.model.Messages;
import main.com.FriendHub.model.User;
import main.com.FriendHub.service.AttachmentsService;
import main.com.FriendHub.service.FriendListService;
import main.com.FriendHub.service.MessageNotificationsService;
import main.com.FriendHub.service.MessagesService;
import main.com.FriendHub.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

	/*
	 * @Autowired UserService service;
	 */

	@Autowired
	FriendListService friendService;

	@Autowired
	UserService userService;

	@Autowired
	MessagesService messagesService;

	@Autowired
	AttachmentsService attachmentsService;

	@Autowired
	MessageNotificationsService messageNotificationsService;

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public ModelAndView chat(ModelMap model, HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		List<FriendList> friendList = friendService.getFriendList(user);
		ModelAndView chatView = new ModelAndView("chat");
		chatView.addObject("friendList", friendList);
		return chatView;
	}

	@RequestMapping(value = "/getChatHistoryWithFriend", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getChatHistoryWithFriend(
			@RequestParam(value = "friendUserID") String friendUserID,
			HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		User friend = userService.getUserByID(Integer.parseInt(friendUserID));
		List<Messages> messageList = messagesService.getRecentMessages(user,
				friend);

		ModelAndView chatWindowView = new ModelAndView("chatWindow");
		chatWindowView.addObject("messageList", messageList);
		chatWindowView.addObject("friendName", friend.getFirstName());
		chatWindowView.addObject("friendID", Integer.parseInt(friendUserID));

		return chatWindowView;
	}
	
	@RequestMapping(value = "/deleteNotifications", method = RequestMethod.GET)
	public @ResponseBody String deleteNotifications(
			@RequestParam(value = "friendUserID") String friendUserID,
			HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		messageNotificationsService.deleteNotifications(Integer.parseInt(friendUserID), user.getUserID());
		return "Success";
	}
	
	@RequestMapping(value = "/updateChatHistory", method = RequestMethod.GET)
	public @ResponseBody ModelAndView updateChatHistory(
			@RequestParam(value = "friendUserID") String friendUserID,
			HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		User friend = userService.getUserByID(Integer.parseInt(friendUserID));
		List<Messages> messageList = messagesService.getRecentMessages(user,
				friend);

		ModelAndView chatBodyView = new ModelAndView("chatBody");
		chatBodyView.addObject("messageList", messageList);
		return chatBodyView;
	}

	@RequestMapping(value = "/updateMessageNotifications", method = RequestMethod.GET)
	public @ResponseBody ModelAndView updateMessageNotifications(
			HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		List<GroupedMessageNotifications> notificationsList = messageNotificationsService
				.getRecentMessageNotifications(user.getUserID());
		ModelAndView messageNotificationView = new ModelAndView("messageNotification");
		messageNotificationView.addObject("notificationsList", notificationsList);
		return messageNotificationView;
	}

	@ResponseBody
	@RequestMapping(value = "/postMessage", method = RequestMethod.POST)
	public ModelAndView postMessage(@RequestParam(value = "text") String text,
			@RequestParam(value = "friendID") String friendID,
			HttpSession httpSession) {
		User user = SessionManager.getCurrentUser(httpSession.getId());
		java.util.Date date = new java.util.Date();
		Messages message = new Messages(text, user, Integer.parseInt(friendID),
				new Timestamp(date.getTime()));
		messagesService.addMessage(message);

		MessageNotifications notification = new MessageNotifications(user,
				Integer.parseInt(friendID), new Timestamp(date.getTime()));
		messageNotificationsService.addMessageNotification(notification);

		ModelAndView messageView = new ModelAndView("message");
		messageView.addObject("message", message);
		return messageView;
	}

	@RequestMapping(value = "/uploadAttachment", method = RequestMethod.POST)
	public @ResponseBody ModelAndView uploadAttachment(
			MultipartHttpServletRequest request, HttpSession httpSession,
			HttpServletResponse response) {
		String friendID = request.getParameter("friendID");
		List<MultipartFile> mpfs = request.getFiles("file");
		MultipartFile mpf = mpfs.get(0);
		User user = SessionManager.getCurrentUser(httpSession.getId());
		java.util.Date date = new java.util.Date();
		Messages message = new Messages("Attachment: "
				+ mpf.getOriginalFilename(), user, Integer.parseInt(friendID),
				new Timestamp(date.getTime()));
		messagesService.addMessage(message);

		MessageNotifications notification = new MessageNotifications(user,
				Integer.parseInt(friendID), new Timestamp(date.getTime()));
		messageNotificationsService.addMessageNotification(notification);

		Attachments attachment = new Attachments();

		try {
			attachment.setMessageID(message);
			attachment.setFile(mpf.getBytes());
			attachment.setFileType(mpf.getContentType());
			attachment.setFileName(mpf.getOriginalFilename());
			attachmentsService.addAttachments(attachment);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView messageView = new ModelAndView("message");
		messageView.addObject("message", message);
		return messageView;
	}

	@RequestMapping(value = "/downloadAttachment", method = RequestMethod.GET)
	public ModelAndView downloadAttachment(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int id = ServletRequestUtils.getRequiredIntParameter(request, "id");

		Attachments attachment = attachmentsService.find(id);
		response.setContentType(attachment.getFileType());
		response.setContentLength(attachment.getFile().length);
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ attachment.getFileName() + "\"");
		FileCopyUtils.copy(attachment.getFile(), response.getOutputStream());

		return null;

	}
}