package com.csye6220.carrentalsystem.dao;

import java.util.List;

import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.MaintenanceRecord;
import com.csye6220.carrentalsystem.model.Mechanic;

public interface MechanicDAO {
	void createMechanic(Mechanic mechanic);
	Mechanic getMechanicById(int mechanicID);
	void updateMechanic(Mechanic mechanic);
	void deleteMechanic(int mechanicID);
	List<Mechanic> getAllMechanics();
	List<Car> getAssignedCarsByMechanic(int mechanicID);
	List<MaintenanceRecord> getMaintenanceRecords(int mechanicID);
}
