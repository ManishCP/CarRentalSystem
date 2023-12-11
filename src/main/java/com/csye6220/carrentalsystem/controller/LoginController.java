package com.csye6220.carrentalsystem.controller;

import com.csye6220.carrentalsystem.model.User; 
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.csye6220.carrentalsystem.service.UserService;
@Controller
public class LoginController {


    @Autowired
    UserService userService;
    
    @GetMapping("/login*")
    public ModelAndView redirectToLoginPage(){
        return new ModelAndView("login_page");
    }

    @PostMapping("/perform-login")
    public ModelAndView checkValidation(@RequestParam String email, @RequestParam String password, HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();

        User user = userService.getUserByEmail(email);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(user == null){
            modelAndView.setViewName("redirect:/login");
            modelAndView.addObject("error", "email-wrong");
        }
        else{
            if(bCryptPasswordEncoder.matches(password, user.getPassword())){
                modelAndView.setViewName("redirect:/");
                request.getSession().setAttribute("user", user);
            }
            else {
                modelAndView.setViewName("redirect:/login");
                modelAndView.addObject("error", "password-wrong");
            }
        }
        return modelAndView;
    }
}

