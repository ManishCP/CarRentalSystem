package com.csye6220.carrentalsystem.model;

import java.util.Date;

public class MaintenanceRecord {
    private int recordID;
    private int carID;
    private int mechanicID;
    private String maintenanceDescription;
    private Date datePerformed;

    public MaintenanceRecord() {} //Default Constructor

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getMechanicID() {
		return mechanicID;
	}

	public void setMechanicID(int mechanicID) {
		this.mechanicID = mechanicID;
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
