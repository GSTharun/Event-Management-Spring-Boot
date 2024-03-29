package com.ty.event.event_management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.ty.event.event_management.util.AESencription;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	@NotNull
	private String name;
	@NotNull
	@Min(999999999)
	@Max(9999999999L)
	private long phoneno;
	@Email(message = "Email is not valid")
	private String email; 
	@Convert(converter=AESencription.class)
	@NotNull
	private String password;

	
	@OneToMany(cascade = CascadeType.ALL)
	List<EventHalls> eventHalls;
	

	@OneToMany
	List<Agent> agents;

}
