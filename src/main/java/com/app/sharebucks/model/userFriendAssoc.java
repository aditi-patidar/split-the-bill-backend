package com.app.sharebucks.model;

public class userFriendAssoc {
	private int userAndFriendAssocId;
	
	private int friendID;
	
	private boolean userID;

	public int getUserAndFriendAssocId() {
		return userAndFriendAssocId;
	}

	public void setUserAndFriendAssocId(int userAndFriendAssocId) {
		this.userAndFriendAssocId = userAndFriendAssocId;
	}

	public int getFriendID() {
		return friendID;
	}

	public void setFriendId(int friendId) {
		this.friendID = friendId;
	}

	public boolean getUserID() {
		return userID;
	}

	public void setUserID(boolean userID) {
		this.userID = userID;
	}
}
