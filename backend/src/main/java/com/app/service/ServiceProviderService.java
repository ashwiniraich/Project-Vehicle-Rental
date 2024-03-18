package com.app.service;



import java.util.List;

import com.app.dto.SpLoginDto;
import com.app.dto.SpRegistrationDto;
import com.app.dto.VehicleRegisterationDto;
import com.app.entities.Booking;
import com.app.entities.ServiceProvider;

public interface ServiceProviderService {

	
	ServiceProvider addProviderDetails(SpRegistrationDto transientServiceProviderdto);

	ServiceProvider authenticateSp(SpLoginDto logindto);
	
	public void addCategoryToServiceProvider(Long serviceProviderId, Long categoryId);
	
	public void addVehicleToServiceProvider(Long serviceProviderId, Long categoryId,VehicleRegisterationDto transientVehicledto);
	
	public String updateStatusOfBooking(Long bookingId,Long serviceProviderId);
	
	List<Booking> getBookingsByServiceProviderId(Long serviceProviderId);
	
	List<Booking>getAllBookings();
}
