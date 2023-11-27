package com.csye6220.carrentalsystem.model;

public class Issue {
    private int issueID;
    private int carID;
    private String description;
    private int reportedByUserID;
    private String status;

    public Issue() {} //default Constructor

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
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

