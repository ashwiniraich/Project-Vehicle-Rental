package com.app.service;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.SpLoginDto;
import com.app.dto.SpRegistrationDto;
import com.app.dto.VehicleRegisterationDto;
import com.app.entities.Booking;
import com.app.entities.Category;
import com.app.entities.ServiceProvider;
import com.app.entities.Vehicle;
import com.app.repository.BookingRepository;
import com.app.repository.CategoryRepository;
import com.app.repository.ServiceProviderRepository;
import com.app.repository.VehicleRepository;

@Service
@Transactional //readOnly:false

public class ServiceProviderImpl implements ServiceProviderService{
	
	@Autowired
	private ServiceProviderRepository spRepo;
	
	@Autowired
	private BookingRepository bookRepo;
	
	@Autowired
	private CategoryRepository catRepo;
	
	@Autowired
	private VehicleRepository vehRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@PostConstruct
	public void init() {
		
	}

	@Override
	public ServiceProvider addProviderDetails(SpRegistrationDto transientServiceProviderdto) {
		
		String encPassword = passwordEncoder.encode(transientServiceProviderdto.getSpPassword());
		transientServiceProviderdto.setSpPassword(encPassword);
		
		ServiceProvider sp= mapper.map(transientServiceProviderdto, ServiceProvider.class);
		return spRepo.save(sp);
	}

	@Override
	public ServiceProvider authenticateSp(SpLoginDto logindto) {
		
		ServiceProvider sp1=spRepo.findBySpEmail(logindto.getSpEmail())
				.orElseThrow(()-> new ResourceNotFoundException("Bad Credentials!!!"));
		
		String rawPassword=logindto.getSpPassword();
		if(sp1!=null && passwordEncoder.matches(rawPassword, sp1.getSpPassword()))
		return sp1;
		else throw new ResourceNotFoundException("Wrong Email or Password");
		//return spRepo.findBySpEmailAndSpPassword(sp1.getSpEmail(),sp1.getSpPassword()).orElseThrow(()-> new ResourceNotFoundException("Bad Credentials!!!"));
	}
	

	@Override
	public void addCategoryToServiceProvider(Long serviceProviderId, Long categoryId) {
        ServiceProvider serviceProvider = spRepo.findById(serviceProviderId)
                .orElseThrow(() -> new ResourceNotFoundException("Service provider not found"));
        Category category = catRepo.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        serviceProvider.getCategories().add(category);
        spRepo.save(serviceProvider);
    }
	
	@Override
	public void addVehicleToServiceProvider(Long serviceProviderId, Long categoryId, VehicleRegisterationDto transientVehicleDto) {
	    ServiceProvider serviceProvider = spRepo.findById(serviceProviderId)
	            .orElseThrow(() -> new ResourceNotFoundException("Service provider not found"));
	    Category category = catRepo.findById(categoryId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

	    Vehicle vehicle = mapper.map(transientVehicleDto, Vehicle.class);
	    
	    // Set the association with ServiceProvider and Category
	    vehicle.setServiceProvider(serviceProvider);
	    vehicle.setCategory(category);

	    // Save the vehicle
	    vehRepo.save(vehicle);

	    // Update associations on ServiceProvider
	    serviceProvider.getCategories().add(category);
	    serviceProvider.getVehicles().add(vehicle);

	    // Save the updated ServiceProvider
	    spRepo.save(serviceProvider);
	}

	@Override
	public String updateStatusOfBooking(Long bookingId,Long serviceProviderId) {
		
		Booking b=bookRepo.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking not found"));
		b.setStatus("Accepted");
		ServiceProvider sp1=spRepo.findById(serviceProviderId).orElseThrow(()->new ResourceNotFoundException("Service provider not found"));
		b.setServiceProvider_id(sp1);;
		bookRepo.save(b);

//		sp1.setId(serviceProviderId);
//		spRepo.save(sp1);
		return "Booking accepted and updated status successfully!!!!!!!";
	}

	@Override
    public List<Booking> getBookingsByServiceProviderId(Long serviceProviderId) {
        return bookRepo.findBookingsByServiceProviderId(serviceProviderId);
    }
		
	

	@Override
	public List<Booking> getAllBookings() {
		return  bookRepo.findAll();
	}
	
	

}
