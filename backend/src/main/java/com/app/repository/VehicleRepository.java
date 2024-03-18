package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.*;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	

}
