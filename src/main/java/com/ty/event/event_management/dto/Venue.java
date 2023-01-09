package com.ty.event.event_management.dto;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Venue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int venueid;
	@NotNull
	private String venuename;
	@NotNull
	private double finalcost;
	
	@OneToOne
	private Admin admin;
	
	@OneToOne
	private EventDetails eventDetails;
}
