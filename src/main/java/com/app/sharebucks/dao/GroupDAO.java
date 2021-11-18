package com.app.sharebucks.dao;

import java.util.List;

import com.app.sharebucks.model.Group;

public interface GroupDAO {
	int createGroupForUser(Group group);
	
	List<Group> getUserGroupsByUserId(int userId);
	
	Group getById(int id);

}
