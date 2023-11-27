//package com.csye6220.carrentalsystem.controller;
//
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
// * 
// * MechanicController
// * handle mechanic-related operations (issue resolution, maintenance updates)
// */
//@Controller
//@RequestMapping("/mechanics")
//public class MechanicController {
//
//    private final MechanicDAO mechanicDAO;
//
//    public MechanicController(MechanicDAO mechanicDAO) {
//        this.mechanicDAO = mechanicDAO;
//    }
//
//    @GetMapping("/list")
//    public ResponseEntity<List<Mechanic>> getAllMechanics() {
//        
//        return ResponseEntity.ok(mechanicDAO.getAllMechanics());
//    }
//
//    @GetMapping("/{mechanicID}")
//    public ResponseEntity<Mechanic> getMechanicDetails(@PathVariable int mechanicID) {
//        
//        return ResponseEntity.ok(mechanicDAO.getMechanicById(mechanicID));
//    }
//
//}
//
//
