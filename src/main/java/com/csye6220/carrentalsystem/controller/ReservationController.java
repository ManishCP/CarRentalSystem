//package com.csye6220.carrentalsystem.controller;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.csye6220.carrentalsystem.model.Reservation;
//import com.csye6220.carrentalsystem.service.ReservationService;
//
//@Controller
//@RequestMapping("/reservations")
//public class ReservationController {
//	
//	@Autowired
//	private ReservationService reservationService;
//
//	@GetMapping("/create") 
//	public String getCreateReservationForm() {
//		return "create_reservation";
//	}
//	
//    @PostMapping("/create")
//    public String createReservation(
//            @RequestParam(name = "userID") int userID,
//            @RequestParam(name = "carID") int carID,
//            @RequestParam(name = "startDate") String startDate,
//            @RequestParam(name = "endDate") String endDate,
//            @RequestParam(name = "status") String status
//    ) {
//        // Parse startDate and endDate to Date type as needed
//        Reservation reservation = new Reservation();
//        reservation.setUserID(userID);
//        reservation.setCarID(carID);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            Date parsedStartDate = dateFormat.parse(startDate);
//            Date parsedEndDate = dateFormat.parse(endDate);
//
//            // Set parsed dates
//            reservation.setStartDate(parsedStartDate);
//            reservation.setEndDate(parsedEndDate);
//        } catch (ParseException e) {
//            // Handle parsing exception (e.g., log it or show an error to the user)
//            e.printStackTrace();
//            // You might want to redirect to an error page or show a message to the user
//            return "redirect:/error";
//        }
//        // Set parsed dates
//        reservation.setStatus(status);
//        reservationService.createReservation(reservation);
//        return "redirect:/reservations/all";
//    }
//
//    @GetMapping("/{reservationID}")
//    public ModelAndView getReservationById(@PathVariable int reservationID) {
//        ModelAndView modelAndView = new ModelAndView("view_reservation");
//        Reservation reservation = reservationService.getReservationById(reservationID);
//        modelAndView.addObject("reservation", reservation);
//        return modelAndView;
//    }
//
//    @PutMapping("/update/{reservationID}")
//    public String updateReservation(
//            @PathVariable int reservationID,
//            @RequestParam(name = "userID") int userID,
//            @RequestParam(name = "carID") int carID,
//            @RequestParam(name = "startDate") String startDate,
//            @RequestParam(name = "endDate") String endDate,
//            @RequestParam(name = "status") String status,
//            RedirectAttributes redirectAttributes
//    ) {
//        // Parse startDate and endDate to Date type as needed
//        Reservation reservation = reservationService.getReservationById(reservationID);
//        reservation.setUserID(userID);
//        reservation.setCarID(carID);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            Date parsedStartDate = dateFormat.parse(startDate);
//            Date parsedEndDate = dateFormat.parse(endDate);
//
//            // Set parsed dates
//            reservation.setStartDate(parsedStartDate);
//            reservation.setEndDate(parsedEndDate);
//        } catch (ParseException e) {
//            // Handle parsing exception (e.g., log it or show an error to the user)
//            e.printStackTrace();
//            // You might want to redirect to an error page or show a message to the user
//            return "redirect:/error";
//        }
//        // Set parsed dates
//        reservation.setStatus(status);
//        reservationService.updateReservation(reservation);
//        return "redirect:/reservations/all";
//    }
//
//    @DeleteMapping("/delete/{reservationID}")
//    public String deleteReservation(@PathVariable int reservationID) {
//    	reservationService.deleteReservation(reservationID);
//        return "redirect:/reservations/all";
//    }
//
//    @GetMapping("/all")
//    public ModelAndView getAllReservations() {
//        ModelAndView modelAndView = new ModelAndView("view_all_reservations");
//        List<Reservation> reservations = reservationService.getAllReservations();
//        modelAndView.addObject("reservations", reservations);
//        return modelAndView;
//    }
//
//    @GetMapping("/byUser/{userID}")
//    public ModelAndView getReservationsByUser(@PathVariable int userID) {
//        ModelAndView modelAndView = new ModelAndView("view_reservations_by_user");
//        List<Reservation> reservations = reservationService.getReservationsByUser(userID);
//        modelAndView.addObject("reservations", reservations);
//        return modelAndView;
//    }
//
//    @GetMapping("/byCar/{carID}")
//    public ModelAndView getReservationsByCar(@PathVariable int carID) {
//        ModelAndView modelAndView = new ModelAndView("view_reservations_by_car");
//        List<Reservation> reservations = reservationService.getReservationsByCar(carID);
//        modelAndView.addObject("reservations", reservations);
//        return modelAndView;
//    }
//}