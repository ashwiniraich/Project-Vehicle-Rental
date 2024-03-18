package com.app.service;

import java.io.IOException;
import java.util.List;
import com.app.dto.CustomerLoginDto;
import com.app.dto.CustomerRegistrationDto;
import com.app.entities.Booking;
import com.app.entities.Category;
import com.app.entities.Customer;
import com.app.entities.Vehicle;

public interface CustomerService {

	Customer addCustomerDetails(CustomerRegistrationDto transientCustomerdto);

	Customer authenticateCust(CustomerLoginDto logindto);

	List<Category> getAllCategoryDetails();

	Booking addBooking(Long customerId, Long vehicleId);

	List<Booking> getAllBookingsById(Long customerId);

	List<Vehicle> getAllVehiclesByCategoryId(Long categoryId);

//	Booking removeBooking(Long customerId, Long serviceId, Long bookingId);
	
	String cancelBooking(Long bookingId);
	

}
