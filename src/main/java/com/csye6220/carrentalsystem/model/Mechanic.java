package com.csye6220.carrentalsystem.model;

import java.util.List;

public class Mechanic {
    private int mechanicID;
    private String mechanicName;
    private String expertiseField;
    private String contactDetails;
    private List<Car> assignedCars; // List of cars assigned for maintenance

    public Mechanic() {} //Default Constructor 

    public int getMechanicID() {
        return mechanicID;
    }

    public void setMechanicID(int mechanicID) {
        this.mechanicID = mechanicID;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public String getExpertiseField() {
        return expertiseField;
    }

    public void setExpertiseField(String expertiseField) {
        this.expertiseField = expertiseField;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public List<Car> getAssignedCars() {
        return assignedCars;
    }

    public void setAssignedCars(List<Car> assignedCars) {
        this.assignedCars = assignedCars;
    }
    
    
}

