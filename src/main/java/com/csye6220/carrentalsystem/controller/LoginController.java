package com.csye6220.carrentalsystem.controller;

import com.csye6220.carrentalsystem.model.User;
import com.csye6220.carrentalsystem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login_page";
    }

    @PostMapping("/perform-login")
    public String checkLogin(@RequestParam String username, @RequestParam String password, Model model) {
        // Your login logic here
        User user = userService.getUserByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            // Successful login, redirect to home or another page
            return "redirect:/user";
        } else {
            // Failed login, redirect back to login page with an error parameter
            model.addAttribute("error", "true");
            return "redirect:/login";
        }
    }
   
}
