package com.csye6220.carrentalsystem.service;

import com.csye6220.carrentalsystem.dao.RentalAgencyDAO;
import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.RentalAgency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalAgencyService  {

	@Autowired
	private RentalAgencyDAO rentalagencyDAO;
	
	public void createRentalAgency(RentalAgency agency) {
		rentalagencyDAO.createRentalAgency(agency);
	}

	public RentalAgency getAgencyByID(int agencyID) {
		return rentalagencyDAO.getAgencyByID(agencyID);
	}

	public void updateAgency(RentalAgency agency) {
		rentalagencyDAO.updateAgency(agency);
	}

	public void deleteAgency(int agencyID) {
		rentalagencyDAO.deleteAgency(agencyID);
	}

	public List<RentalAgency> getAllAgencies() {
		return rentalagencyDAO.getAllAgencies();
	}

	public List<Car> getAvailableCarsByAgency(int agencyID) {
		return rentalagencyDAO.getAvailableCarsByAgency(agencyID);
	}

}



