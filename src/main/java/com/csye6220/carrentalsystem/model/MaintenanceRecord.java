package com.csye6220.carrentalsystem.model;

import java.util.Date; 

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "maintenance_records")
public class MaintenanceRecord {
	
	@Id
    @GeneratedValue
    private int recordID;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private Car car;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private Mechanic mechanic;
	
	@Column(name = "maintenance_description")
    private String maintenanceDescription;
	
	@Column(name = "date_performed")
    private Date datePerformed;

    public MaintenanceRecord() {} 

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public String getMaintenanceDescription() {
		return maintenanceDescription;
	}

	public void setMaintenanceDescription(String maintenanceDescription) {
		this.maintenanceDescription = maintenanceDescription;
	}

	public Date getDatePerformed() {
		return datePerformed;
	}

	public void setDatePerformed(Date datePerformed) {
		this.datePerformed = datePerformed;
	}
    
    
}
