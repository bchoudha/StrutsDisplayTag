package com.test;

import java.util.ArrayList;

/**
 * The Class ActorData.
 */
public class ActorData {

	private String userId;
	private String userName;
	private String emailId;

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

    /**
     * Instantiates a new actor data.
     */
    public ActorData()
    {
        
    }
    
    /**
     * Instantiates a new actor data.
     *
     * @param userId the user id
     * @param userName the user name
     * @param emailId the email id
     */
    public ActorData(String userId, String userName, String emailId)
    {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
    }

    /**
     * Load data.
     *
     * @return the array list
     */
    public ArrayList<ActorData> loadData()
    {
        ArrayList<ActorData> userList = new ArrayList<ActorData>();
        userList.add(new ActorData("USER1","Michael Scott","michael.scott@dundermifflin.com"));
        userList.add(new ActorData("USER2","Dwight Schrute","dwight.schrute@dundermifflin.com"));
        userList.add(new ActorData("USER3","Jim Halpert","jim.halpert@dundermifflin.com"));
        userList.add(new ActorData("USER4","Pam Beesly","pam.beesly@dundermifflin.com"));
        userList.add(new ActorData("USER5","Andy Bernad","andy.bernad@dundermifflin.com"));
        userList.add(new ActorData("USER6","Angela Martin","angela.martin@dundermifflin.com"));
        userList.add(new ActorData("USER7","Rachel Green","rachel.green@friends.com"));
        userList.add(new ActorData("USER8","Monica Geller","monica.geller@friends.com"));
        userList.add(new ActorData("USER9","Phoebe Buffay","phoebe.buffay@friends.com"));
        userList.add(new ActorData("USER10","Joey Tribbiani","joey.tribbiani@friends.com"));
        userList.add(new ActorData("USER11","Chandler Bing","chandler.bing@friends.com"));
        userList.add(new ActorData("USER12","Ross Geller","ross.geller@friends.com"));
        return userList;
    }

}
