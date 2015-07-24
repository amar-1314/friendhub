package main.com.FriendHub.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attachments")
public class Attachments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attachment_ID;
	
	@ManyToOne
	@JoinColumn(name = "MESSAGE_ID", nullable = false)
	private Messages messageID;

	@Column(name = "FILE")
	private byte[] file;
	
	@Column(name = "FILE_NAME")
	private String fileName;
	
	@Column(name = "FILE_TYPE")
	private String fileType;

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getAttachment_ID() {
		return attachment_ID;
	}

	public void setAttachment_ID(int attachment_ID) {
		this.attachment_ID = attachment_ID;
	}

	public Messages getMessageID() {
		return messageID;
	}

	public void setMessageID(Messages messageID) {
		this.messageID = messageID;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
