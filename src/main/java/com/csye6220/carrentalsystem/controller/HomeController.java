package com.csye6220.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String userSelectionForm() {
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
