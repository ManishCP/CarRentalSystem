package com.csye6220.carrentalsystem.model;

import java.util.List;

public class RentalAgency {
    private int agencyID;
    private String agencyName;
    private String location;
    private String contactDetails;
    private List<Car> fleet; // List of cars available for rent
    
    public RentalAgency() {} //Default Constructor
    

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

