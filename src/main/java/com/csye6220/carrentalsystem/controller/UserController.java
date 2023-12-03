package com.csye6220.carrentalsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@GetMapping("/")
	public String userSelectionForm() {
		return"UserSelection";
	}

	@PostMapping("/customer")
	public String CustomerLogin() {
		return "CustomerPortal";
	}
	
	@PostMapping("/RentalAgency")
	public String RentalAgencyLogin() {
		return "RentalAgencyPortal";
	}
	
	@PostMapping("/Mechanic")
	public String Mechanic() {
		return "MechanicPortal";
	}
	
	
}
