package com.csye6220.carrentalsystem.model;

import java.util.List; 

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "rental_agencies")
public class RentalAgency {
	
	@Id
    @GeneratedValue
    private int agencyID;
	
	@Column(name = "agency_name")
    private String agencyName;
	
	@Column(name = "location")
    private String location;
	
	@Column(name = "contact_details")
    private String contactDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "fleet")
    private List<Car> fleet; 
    
    public RentalAgency() {}
    

    public int getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(int agencyID) {
        this.agencyID = agencyID;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public List<Car> getFleet() {
        return fleet;
    }

    public void setFleet(List<Car> fleet) {
        this.fleet = fleet;
    }

    
}

