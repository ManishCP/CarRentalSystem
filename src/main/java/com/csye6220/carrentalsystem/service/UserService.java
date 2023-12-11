package com.csye6220.carrentalsystem.service;

import com.csye6220.carrentalsystem.dao.UserDAO; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.csye6220.carrentalsystem.model.MyUserDetails;
import com.csye6220.carrentalsystem.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
		
	public void createUser(User user) {
		System.out.println("Creation "+user.getUsername());
		userDAO.createUser(user);
	}
	
	public User getUserByID(int userID) {
		return userDAO.getUserByID(userID);
	}
	
	public void update(User user) {
		userDAO.update(user);
	}
	
	public void delete(int userID) {
		userDAO.delete(userID);
	}
	
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}
	
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}
	
	public User getUserByUsername(String username) {
		return userDAO.getUserByUsername(username);
	}
	
	public UserDetails loadUserByEmail(String email) 
			throws UsernameNotFoundException {
		User user = userDAO.getUserByEmail(email);		
		return new MyUserDetails(user);
	}

}
