package com.csye6220.carrentalsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.csye6220.carrentalsystem.model.RentalAgency;
import com.csye6220.carrentalsystem.service.RentalAgencyService;

import java.util.List;


/**
 * @author manish
 * RentalAgencyController - manage rental agency-related tasks (dashboard, inventory management)
 */



@RestController
@RequestMapping("/rental-agencies")
public class RentalAgencyController {

    private final RentalAgencyService rentalAgencyService;

    @Autowired
    public RentalAgencyController(RentalAgencyService rentalAgencyService) {
        this.rentalAgencyService = rentalAgencyService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createRentalAgency(@RequestBody RentalAgency rentalAgency) {
        rentalAgencyService.createRentalAgency(rentalAgency);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rental agency created successfully");
    }

    @GetMapping("/{agencyID}")
    public ResponseEntity<RentalAgency> getRentalAgencyById(@PathVariable int agencyID) {
        RentalAgency rentalAgency = rentalAgencyService.getAgencyByID(agencyID);
        return rentalAgency != null ? ResponseEntity.ok(rentalAgency) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{agencyID}")
    public ResponseEntity<String> updateRentalAgency(@PathVariable int agencyID, @RequestBody RentalAgency updatedAgency) {
        RentalAgency existingAgency = rentalAgencyService.getAgencyByID(agencyID);
        if (existingAgency != null) {
            updatedAgency.setAgencyID(agencyID);
            rentalAgencyService.updateAgency(updatedAgency);
            return ResponseEntity.ok("Rental agency updated successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{agencyID}")
    public ResponseEntity<String> deleteRentalAgency(@PathVariable int agencyID) {
        RentalAgency existingAgency = rentalAgencyService.getAgencyByID(agencyID);
        if (existingAgency != null) {
            rentalAgencyService.deleteAgency(agencyID);
            return ResponseEntity.ok("Rental agency deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<RentalAgency>> getAllRentalAgencies() {
        List<RentalAgency> rentalAgencies = rentalAgencyService.getAllAgencies();
        return ResponseEntity.ok(rentalAgencies);
    }

    // Other methods for handling rental agency-related requests
}


