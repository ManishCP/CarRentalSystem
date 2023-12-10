package com.csye6220.carrentalsystem.controller;

import java.util.List;    

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.csye6220.carrentalsystem.model.Car;
import com.csye6220.carrentalsystem.model.CarType;
import com.csye6220.carrentalsystem.service.CarService;


@Controller
@RequestMapping("/cars")
public class CarController {
	 
	@Autowired
	private CarService carService;
	
	
	//This is to show the portal to add all the cars
	@GetMapping("/add") 
	public String getCarAddForm() {
		return "add_car";
	}
	
	
	//This is to perform operations when car data is added
	@PostMapping("/add")
    public String addCar(
            @RequestParam(name = "car-make", required = false) String carMake,
            @RequestParam(name = "car-model", required = false) String carModel,
            @RequestParam(name = "car-year", required = false) int carYear,
            @RequestParam(name = "car-type", required = false) String carType,
            @RequestParam(name = "registration-number", required = false) String registrationNumber,
            @RequestParam(name = "availability", required = false) boolean availability,
            @RequestParam(name = "current-location", required = false) String currentLocation
    ) {
        Car car = new Car(carMake, carModel, carYear, CarType.valueOf(carType), registrationNumber, availability, currentLocation);
        carService.createCar(car);
        return "redirect:/cars/all";
    }

	//When view car is given this operation is performed 
    @GetMapping("/{carID}")
    public ModelAndView getCarByID(@PathVariable int carID) {
        ModelAndView modelAndView = new ModelAndView("view_car");
        Car car = null;
		try {
			car = carService.getCarByID(carID);
		} catch (Exception e) {
			e.printStackTrace();
		}
        modelAndView.addObject("car", car);
        return modelAndView;
    }
    
    //This operation is performed when edit car is given 
    @GetMapping("/edit/{carID}") 
    public String editCarForm(@PathVariable int carID, Model model) {
        Car car = carService.getCarByID(carID);
        model.addAttribute("carId", carID);
        model.addAttribute("car", car);
        return "edit_car_content";
    }

    @PostMapping("edit")
    public String editCar(
    		@RequestParam(name = "car-id") int carId,
            @RequestParam(name = "car-make", required = false) String carMake,
            @RequestParam(name = "car-model", required = false) String carModel,
            @RequestParam(name = "car-year", required = false) int carYear,
            @RequestParam(name = "car-type", required = false) String carType,
            @RequestParam(name = "registration-number", required = false) String registrationNumber,
            @RequestParam(name = "availability", required = false) boolean availability,
            @RequestParam(name = "current-location", required = false) String currentLocation,
            RedirectAttributes redirectAttributes
    ) {
        Car car = new Car(carMake, carModel, carYear, CarType.valueOf(carType), registrationNumber, availability, currentLocation);
        car.setCarID(carId);
        carService.update(car);
        return "redirect:/cars/all";
    }

    @GetMapping("/delete/{carID}")
    public String deleteCar(@PathVariable int carID) {
        Car car = carService.getCarByID(carID);
        carService.delete(car);
        return "redirect:/cars/all";
    }

    @GetMapping("/all")
    public ModelAndView getAllCars() {
        ModelAndView modelAndView = new ModelAndView("view_all_cars");
        List<Car> cars = carService.getAllCars();
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @GetMapping("/byLocation")
    public ModelAndView getCarsByLocation(@RequestParam String location) {
        ModelAndView modelAndView = new ModelAndView("view_cars_by_location");
        List<Car> cars = carService.getCarsByLocation(location);
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @GetMapping("/byAvailability")
    public ModelAndView getCarsByAvailability(@RequestParam boolean availability) {
        ModelAndView modelAndView = new ModelAndView("view_cars_by_availability");
        List<Car> cars = carService.getCarsByAvailablity(availability);
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }
    
}
