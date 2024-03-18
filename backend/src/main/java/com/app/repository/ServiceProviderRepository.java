package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.*;

@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

	Optional<ServiceProvider> findBySpEmail(String em);
	
//	@Modifying
//	@Query("update Hospital h set h.email=:email,h.address=:address,h.contactNo=:mobile where h.hid=:hid")
//	int updateHospital(String email, String address, long mobile, int hid);
	
	

}
