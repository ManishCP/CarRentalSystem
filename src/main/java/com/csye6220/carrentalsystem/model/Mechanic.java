package com.csye6220.carrentalsystem.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "mechanics")
public class Mechanic {
	
	@Id
    @GeneratedValue
    private int mechanicID;
	
	@Column(name = "mechanic_name")
    private String mechanicName;
	
	@Column(name = "expertise_field")
    private String expertiseField;
	
	@Column(name = "contact_details")
    private String contactDetails;

	@OneToMany(cascade = CascadeType.ALL)
    @Column(name = "assigned_cars")
    private List<Car> assignedCars;

    public Mechanic() {}  

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

