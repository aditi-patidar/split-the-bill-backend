package com.app.sharebucks.dao;

import java.util.List;
import com.app.sharebucks.model.userFriendAssoc;

public interface userFriendsDAO {
	
	int createUserFriend(userFriendAssoc userfriend);
	
	List<userFriendAssoc> getUserFriendsByUserID(int userID);
	
}
