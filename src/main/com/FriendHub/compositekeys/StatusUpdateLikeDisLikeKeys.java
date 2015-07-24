package main.com.FriendHub.compositekeys;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import main.com.FriendHub.model.StatusUpdate;
import main.com.FriendHub.model.User;

@Embeddable 
public class StatusUpdateLikeDisLikeKeys implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @ManyToOne
	@JoinColumn(name = "status_update_id")
	protected  StatusUpdate status_update_id;
	 
	@ManyToOne
	@JoinColumn(name = "UserID")
    protected User UserID;
    
    public StatusUpdate getStatus_update_id() {
		return status_update_id;
	}

	public void setStatus_update_id(StatusUpdate status_update_id) {
		this.status_update_id = status_update_id;
	}

	public User getUserID() {
		return UserID;
	}

	public void setUserID(User userID) {
		UserID = userID;
	}

	public StatusUpdateLikeDisLikeKeys() {}
	
	public StatusUpdateLikeDisLikeKeys(StatusUpdate status_update_id, User UserID) {
        this.status_update_id = status_update_id;
        this.UserID = UserID;
    }
	
	
    
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( !(other instanceof StatusUpdateLikeDisLikeKeys) ) return false;

        final StatusUpdateLikeDisLikeKeys cat = (StatusUpdateLikeDisLikeKeys) other;

        if ( !cat.getStatus_update_id().equals( getStatus_update_id() ) ) return false;
        if ( !cat.getUserID().equals( getUserID() ) ) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = getStatus_update_id().hashCode();
        result = 29 * result + getUserID().getUserID();
        return result;
    }
    
    

}
