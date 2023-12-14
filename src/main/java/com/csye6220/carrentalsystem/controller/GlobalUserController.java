//package com.csye6220.carrentalsystem.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import com.csye6220.carrentalsystem.model.User;
//import com.csye6220.carrentalsystem.service.CarService;
//import com.csye6220.carrentalsystem.service.UserService;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//public class GlobalUserController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@ModelAttribute("loggedUser")
//    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails user) {
//		if(user != null) {
//			
//		}
//    	return null;
//    }
//}