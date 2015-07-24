package main.com.FriendHub.compositekeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class FriendListKeys implements Serializable  {

	@Column(name = "User_ID",nullable = false)
	protected Integer User_ID;;
	
	@Column(name = "Friend_User_ID",nullable = false)
    protected Integer Friend_User_ID;

	@Override
	 public boolean equals(Object other) {
	        if (this == other)
	        	return true;
	        if ( other == null)
	        return false;

	        if(getClass() != other.getClass())
	        	return false;
	        
	        
	        return true;
	    }

	 @Override
	    public int hashCode() {
	    	final int prime =23;
	        int result =1;
	        result = prime * result + User_ID.hashCode();
	        result = prime * result + Friend_User_ID.hashCode();
	        return result;
	    }
	    
    
}
