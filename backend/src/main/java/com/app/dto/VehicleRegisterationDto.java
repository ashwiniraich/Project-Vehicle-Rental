package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VehicleRegisterationDto {
	
	private String model;
	
	private String color;
	
	private int milaege;
	
	private String fuelType;
	
	private String status;
	
	private int rent;
}
