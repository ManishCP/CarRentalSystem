package com.csye6220.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.RentalAgency;
import com.csye6220.carrentalsystem.service.RentalAgencyService;
import com.csye6220.carrentalsystem.service.ReservationService;

import java.util.List;



@Controller
@RequestMapping("/rental-agencies")
public class RentalAgencyController {
	
	@Autowired
	private RentalAgencyService rentalAgencyService;

	@GetMapping("/adminPortal")
    public String showAdminPortal() {
        return "admin_portal";
    }
	
    @PostMapping("/add")
    public String addRentalAgency(
            @RequestParam(name = "agency-name", required = false) String agencyName,
            @RequestParam(name = "location", required = false) String location,
            @RequestParam(name = "contact-details", required = false) String contactDetails
    ) {
        RentalAgency rentalAgency = new RentalAgency();
        rentalAgency.setAgencyName(agencyName);
        rentalAgency.setLocation(location);
        rentalAgency.setContactDetails(contactDetails);
        rentalAgencyService.createRentalAgency(rentalAgency);
        return "redirect:/rental-agencies/all";
    }

    @GetMapping("/{agencyID}")
    public ModelAndView getRentalAgencyByID(@PathVariable int agencyID) {
        ModelAndView modelAndView = new ModelAndView("view_rental_agency");
        RentalAgency rentalAgency = rentalAgencyService.getAgencyByID(agencyID);
        modelAndView.addObject("rentalAgency", rentalAgency);
        return modelAndView;
    }
    
    @GetMapping("/edit/{agencyID}") 
    public String editagencyForm(@PathVariable int agencyID, Model model) {
        RentalAgency rentalAgency = rentalAgencyService.getAgencyByID(agencyID);
        model.addAttribute("agencyId", agencyID);
        model.addAttribute("RentalAgency", rentalAgency);
        return "edit_rental_agency_content";
    }

    @PostMapping("edit")
    public String editRentalAgency(
            @PathVariable int agencyID,
            @RequestParam(name = "agency-name", required = false) String agencyName,
            @RequestParam(name = "location", required = false) String location,
            @RequestParam(name = "contact-details", required = false) String contactDetails,
            RedirectAttributes redirectAttributes
    ) {
        RentalAgency rentalAgency = rentalAgencyService.getAgencyByID(agencyID);
        rentalAgency.setAgencyName(agencyName);
        rentalAgency.setLocation(location);
        rentalAgency.setContactDetails(contactDetails);
        rentalAgencyService.updateAgency(rentalAgency);
        return "redirect:/rental-agencies/all";
    }

    @GetMapping("/delete/{agencyID}")
    public String deleteRentalAgency(@PathVariable int agencyID) {
        RentalAgency rentalAgency = rentalAgencyService.getAgencyByID(agencyID);
        rentalAgencyService.deleteAgency(agencyID);
        return "redirect:/rental-agencies/all";
    }
   

    @GetMapping("/all")
    public ModelAndView getAllRentalAgencies() {
        ModelAndView modelAndView = new ModelAndView("view_all_rental_agencies");
        List<RentalAgency> rentalAgencies = rentalAgencyService.getAllAgencies();
        modelAndView.addObject("rentalAgencies", rentalAgencies);
        return modelAndView;
    }

    @GetMapping("/{agencyID}/fleet")
    public ModelAndView getRentalAgencyFleet(@PathVariable int agencyID) {
        ModelAndView modelAndView = new ModelAndView("view_rental_agency_fleet");
        RentalAgency rentalAgency = rentalAgencyService.getAgencyByID(agencyID);
        List<Car> fleet = rentalAgency.getFleet();
        modelAndView.addObject("rentalAgency", rentalAgency);
        modelAndView.addObject("fleet", fleet);
        return modelAndView;
    } 
}


