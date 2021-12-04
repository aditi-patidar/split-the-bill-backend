package com.app.sharebucks.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.sharebucks.dao.UserDAO;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserDAO userDAO;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		com.app.sharebucks.model.User user = userDAO.getUserByEmailId(username);
		
		return new User(username, user.getPassword(), new ArrayList<>());
	}
	

}
