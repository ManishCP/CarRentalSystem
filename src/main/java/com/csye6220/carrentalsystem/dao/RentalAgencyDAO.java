package com.csye6220.carrentalsystem.dao;

import java.util.List;

import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.RentalAgency;

public interface RentalAgencyDAO {
	void createRentalAgency(RentalAgency agency);
	RentalAgency getAgencyByID(int agencyID);
	void updateAgency(RentalAgency agency);
	void deleteAgency(int agencyID);
	
	List<RentalAgency> getAllAgencies();
	List<Car> getAvailableCarsByAgency(int agencyID);
}
