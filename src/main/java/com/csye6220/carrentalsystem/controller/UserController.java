package com.csye6220.carrentalsystem.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csye6220.carrentalsystem.model.User;
import com.csye6220.carrentalsystem.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/add") 
	public String getUsersAddForm() {
		return "user_details_entering";
	}
	
	@PostMapping("/signup/customer") 
	public String getSignupCustomerForm() {
		return "signup_customer";
	}

    @PostMapping("/create")
    public String createUser(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "phoneNumber") Long phoneNumber
    ) {
        User user = new User(username, email, password, phoneNumber);
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/{userID}")
    public ModelAndView getUserByID(@PathVariable int userID) {
        ModelAndView modelAndView = new ModelAndView("view_user");
        User user = userService.getUserByID(userID);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
    
    @GetMapping("/update/{userID}") 
    public String editagencyForm(@PathVariable int userID, Model model) {
        User user = userService.getUserByID(userID);
        model.addAttribute("user", user);
        return "edit_user_info";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("userID") Long userID, Model model) {
    	user.setUserID(userID); // Obtain userID from hidden field
        userService.update(user);
        return "redirect:/users/all";
    }

    @GetMapping("/delete/{userID}")
    public String deleteUser(@PathVariable int userID) {
    	userService.delete(userID);
        return "redirect:/users/all";
    }

    @GetMapping("/all")
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("view_all_users");
        List<User> users = userService.getAllUsers();
        modelAndView.addObject("users", users);
        return modelAndView;
    }	
	
}
