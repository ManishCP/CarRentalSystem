package com.csye6220.carrentalsystem.model;

import jakarta.persistence.CascadeType; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "issues")
public class Issue {
	
	@Id
	@GeneratedValue
	private int issueID;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private Car car;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "reported_by_UserID")
    private int reportedByUserID;
	
	@Column(name = "status")
    private String status;

    public Issue() {} 

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReportedByUserID() {
        return reportedByUserID;
    }

    public void setReportedByUserID(int reportedByUserID) {
        this.reportedByUserID = reportedByUserID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}

