package com.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.*;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

Category findByCatName(String catname);	

@Query("SELECT v FROM Vehicle v JOIN v.category c WHERE c.id = :categoryId")
List<Vehicle> findVehicleByCategoryId(@Param("categoryId") Long categoryId);

	

}
