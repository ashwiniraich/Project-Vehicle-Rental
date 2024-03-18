package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Vehicle extends BaseEntity {

	@Column(length = 20)
	private String model;
	@Column(length = 20)
	private String color;
	@Column(length = 20)
	private int milaege;
	@Column(length = 20, nullable = false)
	private String fuelType;
	@Column(length = 20)
	private String status;
	@Column(length = 10)
	private int rent;


	/*  @JsonIgnore
	  
	  @ManyToOne
	  
	  @JoinColumn(name = "category_id") 
	  private Category category_id;
	  
	  @JsonIgnore
	  
	  @OneToOne
	  
	  @JoinColumn(name= "sp_id") private ServiceProvider sp_id;
	 */



	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;
}
