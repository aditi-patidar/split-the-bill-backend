package com.app.sharebucks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.sharebucks.model.Group;
import com.app.sharebucks.services.GroupService;

@RestController
public class groupController {
	
	@Autowired
	GroupService groupService;
	
	@GetMapping("/user-groups/{userId}")
	public List<Group> getUserGroups(@PathVariable int userId) {
		return groupService.getUserGroupsByUserId(userId);
		
		// return groupDAO.getUserGroupsByUserId(userId);
	}
	
	@PostMapping("/create-group")
	public int createGroup(@RequestBody Group group) {
		System.out.println("========group==28==="+ group.getName());
		System.out.println("========group==28==="+ group.getGroupType());
		return groupService.createGroupForUser(group);
		//return groupDAO.createGroupForUser(group);
		
	}

}
