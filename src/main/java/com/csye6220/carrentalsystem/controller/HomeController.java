package com.csye6220.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csye6220.carrentalsystem.model.User;
import com.csye6220.carrentalsystem.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/")
	public String userSelectionForm() {
//		User user = new User("sefdr", "esgsrs", "esfwrs", 244353454L);
		User user = new User("yusuf", "yusuf", "yusuf", 244353454L);
		userservice.createUser(user);
		
		return"login_page";
	}

	@GetMapping("/user")
	public String CustomerLogin() {
		return "customer_portal";
	}
	
	@PostMapping("/agencyStaff")
	public String RentalAgencyLogin() {
		return "rental_agency_portal";
	}
	
	@PostMapping("/continue-as-guest")
	public String guestlogin() {
		return "ContinueAsGuest";
	}

	
	@PostMapping("/carsagencycontrols")
	public String CarsActionByRentalAgency() {
		return "cars_agency_controls";
	}
	
	@PostMapping("/adminPortal")
    public String showAdminPortal() {
        return "admin_portal";
    }

}
