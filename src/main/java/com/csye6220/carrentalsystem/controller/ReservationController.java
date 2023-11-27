//package com.csye6220.carrentalsystem.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author manis
// * 
// * 
// * ReservationController
// * handle reservation requests (creation, modification, cancellation)
// */
//
//@Controller
//@RequestMapping("/reservations")
//public class ReservationController {
//
//    private final ReservationDAO reservationDAO;
//
//    public ReservationController(ReservationDAO reservationDAO) {
//        this.reservationDAO = reservationDAO;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation) {
//        
//        return ResponseEntity.ok("Reservation created successfully");
//    }
//
//    @PutMapping("/{reservationID}")
//    public ResponseEntity<String> updateReservation(@PathVariable int reservationID, @RequestBody Reservation updatedReservation) {
//        
//        return ResponseEntity.ok("Reservation updated successfully");
//    }
//
//    @DeleteMapping("/{reservationID}")
//    public ResponseEntity<String> cancelReservation(@PathVariable int reservationID) {
//       
//        return ResponseEntity.ok("Reservation canceled successfully");
//    }
//
//}