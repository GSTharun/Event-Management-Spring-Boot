package com.ty.event.event_management.dto;


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
public class Ticket {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int ticketid;
	
	@OneToOne
	private Venue venue;
	
	
	
	
	
}
