package com.ty.event.event_management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String name;
	private long phoneno;
	private String email; 
	private String password;

	@OneToMany(cascade = CascadeType.PERSIST)
	List<EventHalls> eventHalls;
	
	@OneToMany
	List<Agent> agents;

}
