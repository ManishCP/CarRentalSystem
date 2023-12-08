package com.csye6220.carrentalsystem.dao;

import com.csye6220.carrentalsystem.model.Car; 

import java.util.List;

public interface CarDAO {
	void createCar(Car car);
	Car getCarByID(int carID);
	void update(Car car);
	void delete(Car car);
	
	List<Car> getAllCars();
	List<Car> getCarsByLocation(String location);
	List<Car> getCarsByAvailablity(boolean availability);
    
}

//<form th:action="@{/users/signup/customer}" method="post">
//
//<div class="form-group">
//<label for="Location">Filter by Location:</label>
//<select id="Location-type" name="Location" required>
//    <option th:each="type : ${T(com.csye6220.carrentalsystem.model.CarType).values()}"
//            th:value="${type}" th:text="${type}" th:selected="${type == car.carType}"></option>
//</select>
//</div>
//
//<div class="form-group">
//<label for="registration-number">Registration Number:</label>
//<input type="text" id="registration-number" name="registration-number" th:value="${car.registrationNumber}" required />
//</div>
//</form>
