package com.csye6220.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String userSelectionForm() {
		return"homePage";
	}

	@PostMapping("/user")
	public String CustomerLogin() {
		return "CustomerPortal";
	}
	
	@PostMapping("/agencyStaff")
	public String RentalAgencyLogin() {
		return "RentalAgencyPortal";
	}
	
	@PostMapping("/continue-as-guest")
	public String guestlogin() {
		return "ContinueAsGuest";
	}

	
	@PostMapping("/carsagencycontrols")
	public String CarsActionByRentalAgency() {
		return "cars_agency_controls";
	}

}
