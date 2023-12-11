package com.csye6220.carrentalsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.csye6220.carrentalsystem.dao.UserDAO;
import com.csye6220.carrentalsystem.model.MyUserDetails;
import com.csye6220.carrentalsystem.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			User user = userDAO.getUserByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyUserDetails(user);
	}

}
