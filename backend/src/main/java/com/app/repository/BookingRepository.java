package com.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {


	@Query("SELECT b FROM Booking b WHERE b.serviceProvider_id.id = :serviceProviderId")
    List<Booking> findBookingsByServiceProviderId(@Param("serviceProviderId") Long serviceProviderId);


	//int updateStatus(String status, Long bookingId);
	
	
}
