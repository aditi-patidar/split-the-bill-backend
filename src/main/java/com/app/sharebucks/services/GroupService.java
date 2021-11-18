package com.app.sharebucks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.sharebucks.dao.GroupDAO;
import com.app.sharebucks.model.Group;

@Service
public class GroupService {
	
	@Autowired
	GroupDAO groupDao;
	
	public int createGroupForUser(Group group) {
		return groupDao.createGroupForUser(group);
	}
	
	public List<Group> getUserGroupsByUserId(int userId) {
		return groupDao.getUserGroupsByUserId(userId);
	}

}
