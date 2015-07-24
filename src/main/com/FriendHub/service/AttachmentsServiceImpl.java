package main.com.FriendHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.com.FriendHub.dao.AttachmentsDao;
import main.com.FriendHub.model.Attachments;
import main.com.FriendHub.model.User;

@Service("attachmentsService")
@Transactional(propagation= Propagation.SUPPORTS)
public class AttachmentsServiceImpl implements AttachmentsService {

	@Autowired
	private AttachmentsDao attachmentsDao;

	@Override
	public void addAttachments(Attachments attachment) {
		attachmentsDao.addAttachments(attachment);
	}

	@Override
	public List<Attachments> getListOfAttachments(User user, User friend) {
		return attachmentsDao.getListOfAttachments(user, friend);
	}

	@Override
	public Attachments find(int id) {
		// TODO Auto-generated method stub
		return attachmentsDao.find(id);
	}

}
