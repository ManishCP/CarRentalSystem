
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
		return "login_page";
	}

	@GetMapping("/user")
	public String CustomerLogin() {
		
		return "customer_portal";
	}
	
	@GetMapping("/agencyStaff")
	public String RentalAgencyLogin() {
		return "rental_agency_portal";
	}
	
	@PostMapping("/error")
	public String errorpage() {
		return "login_page";
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
