package com.csye6220.carrentalsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.carrentalsystem.dao.MechanicDAO;
import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.MaintenanceRecord;
import com.csye6220.carrentalsystem.model.Mechanic;

@Service
public class MechanicService {
	
	@Autowired
	private MechanicDAO mechanicDAO;
	
	public void createMechanic(Mechanic mechanic) {
		mechanicDAO.createMechanic(mechanic);		
	}

	public Mechanic getMechanicById(int mechanicID) {
		return mechanicDAO.getMechanicById(mechanicID);
	}

	public void updateMechanic(Mechanic mechanic) {
		mechanicDAO.updateMechanic(mechanic);		
	}

	public void deleteMechanic(int mechanicID) {
		mechanicDAO.deleteMechanic(mechanicID);		
	}

	public List<Mechanic> getAllMechanics() {
		return mechanicDAO.getAllMechanics();
	}

	public List<Car> getAssignedCarsByMechanic(int mechanicID) {
		return mechanicDAO.getAssignedCarsByMechanic(mechanicID);
	}

	public List<MaintenanceRecord> getMaintenanceRecords(int mechanicID) {
		return mechanicDAO.getMaintenanceRecords(mechanicID);
	}
}
