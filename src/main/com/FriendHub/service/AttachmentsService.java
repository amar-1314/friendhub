package main.com.FriendHub.service;

import java.util.List;

import main.com.FriendHub.model.Attachments;
import main.com.FriendHub.model.User;

public interface AttachmentsService {
	public void addAttachments(Attachments attachment);
	public List<Attachments> getListOfAttachments(User user, User friend);
	public Attachments find(int id);
}
