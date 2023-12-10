package com.csye6220.carrentalsystem.controller;

import com.csye6220.carrentalsystem.model.User;
import com.csye6220.carrentalsystem.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession; // Import HttpSession
import org.springframework.beans.factory.annotation.Autowired;
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
    public String checkLogin(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        // Your login logic here
        User user = userService.getUserByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            // Successful login, set user role in the session and redirect
            session.setAttribute("userRole", user.getRole());

            if ("ADMIN".equals(user.getRole())) {
                // Redirect to admin page
                return "redirect:/admin";
            } else {
                // Redirect to user page
                return "redirect:/user";
            }
        } else {
            // Failed login, redirect back to login page with an error parameter
            model.addAttribute("error", "true");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate session on logout
        session.invalidate();
        return "redirect:/login";
    }
}
