//package com.csye6220.carrentalsystem.controller;
//
//import java.util.List;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author manis
// * 
// * CarController:
// * manage car-related functionalities - listing cars; availability; reservations
// */
//@Controller
//@RequestMapping("/cars")
//public class CarController {
//
//    private final CarDAO carDAO;
//
//    public CarController(CarDAO carDAO) {
//        this.carDAO = carDAO;
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<Car>> getAllCars() {
//        
//        return ResponseEntity.ok(carDAO.getAllCars());
//    }
//
//    @GetMapping("/{carID}")
//    public ResponseEntity<Car> getCarDetails(@PathVariable int carID) {
//        
//        return ResponseEntity.ok(carDAO.getCarById(carID));
//    }
//
//}
