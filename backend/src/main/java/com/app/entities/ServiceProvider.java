package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "service_provider")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "spPassword")
public class ServiceProvider extends BaseEntity {
	@Column(length = 20)
	private String spFirstname;
	@Column(length = 20)
	private String spLastname;
	@Column(length = 50)
	private String spEmail;
	@Column(length = 100 , nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String spPassword;
	private String spAddress;
	@Column(length = 10, unique = true)
	private Long spMobno;
	
	@CreationTimestamp
	private LocalDate registerDate;
	@Column
	private Boolean isVerified=false;
	
	  

	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "service_provider_categories",
	        joinColumns = @JoinColumn(name = "service_provider_id"),
	        inverseJoinColumns = @JoinColumn(name = "category_id"))
	    private List<Category> categories = new ArrayList<>();
	
	    @JsonIgnore
	    @OneToMany(mappedBy = "serviceProvider",cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Vehicle> vehicles = new ArrayList<>();
	    
	    
	
	
}
