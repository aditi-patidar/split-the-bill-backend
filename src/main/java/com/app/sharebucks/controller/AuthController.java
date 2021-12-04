package com.app.sharebucks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.sharebucks.dao.UserDAO;
import com.app.sharebucks.model.JwtRequest;
import com.app.sharebucks.model.JwtResponse;
import com.app.sharebucks.model.User;
import com.app.sharebucks.services.UserService;
import com.app.sharebucks.utility.JWTUtility;

@RestController
public class AuthController {
	
	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;
    
    @Autowired
	UserDAO userDAO;
	
	
	@GetMapping("/")
	public String home() {
		return "welcome!!!";
	}
	
	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody User userRequest) throws Exception {	
		
		boolean isUserFound = userDAO.validateUser(userRequest.getEmailId(),  userRequest.getPassword());
		
		if (!isUserFound) {
			throw new UsernameNotFoundException("User not found");
		}
		 try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(
	                    		userRequest.getEmailId(),
	                    		userRequest.getPassword()
	                    )
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("INVALID_CREDENTIALS", e);
	        }

	        final UserDetails userDetails
	                = userService.loadUserByUsername(userRequest.getEmailId());

	        final String token =
	                jwtUtility.generateToken(userDetails);

	        return new JwtResponse(token);
	    }
		
	
}
