package com.app.sharebucks.dao;

import com.app.sharebucks.model.User;

public interface UserDAO {
	
	public boolean validateUser(String emailId, String password);
	
	public User getUserByEmailId(String emailId);

}
