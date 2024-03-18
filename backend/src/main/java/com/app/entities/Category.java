package com.app.entities;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Category extends BaseEntity{
	@Column(length = 20, unique = true)
	private String catName;   	
	
	
	@ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	@JsonIgnore
    private List<ServiceProvider> serviceProviders = new ArrayList<>();

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Vehicle> vehicles = new ArrayList<>();
//	@ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
//    private Set<ServiceProvider> serviceProviders = new HashSet<>();
}
