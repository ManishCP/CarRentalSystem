package com.csye6220.carrentalsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csye6220.carrentalsystem.dao.CarDAO;
import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.MaintenanceRecord;

@Service
public class CarService {
	
	@Autowired
	private CarDAO carDAO;
//
//	public void createCar(Car car) {
//		carDAO.createCar(car);
//	}
//
//	public Car getCarByID(int carID) {
//		return carDAO.getCarByID(carID);
//	}
//
//	public void update(Car car) {
//		carDAO.update(car);
//	}
//
//	public void delete(Car car) {
//		carDAO.delete(car);
//	}
//
//	public List<Car> getAllCars() {
//		return carDAO.getAllCars();
//	}
//
//	public List<Car> getCarsByLocation(String location) {
//		return carDAO.getCarsByLocation(location);
//	}
//
//	public List<Car> getCarsByAvailablity(boolean availability) {
//		return carDAO.getCarsByAvailablity(availability);
//	}
//
//	public List<MaintenanceRecord> getMaintenanceRecords(int carID) {
//		return carDAO.getMaintenanceRecords(carID);
//	}

}
