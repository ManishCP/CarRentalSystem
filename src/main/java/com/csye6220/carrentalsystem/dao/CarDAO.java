package com.csye6220.carrentalsystem.dao;

import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.MaintenanceRecord;
import com.csye6220.carrentalsystem.model.User;
import com.csye6220.carrentalsystem.model.UserRole;

import java.util.List;

public interface CarDAO {
	void createCar(Car car);
	Car getCarByID(int carID);
	void update(Car car);
	void delete(Car car);
	
	List<Car> getAllCars();
	List<Car> getCarsByLocation(String location);
	List<Car> getCarsByAvailablity(boolean availability);
    
	List<MaintenanceRecord> getMaintenanceRecords(int carID);

}
