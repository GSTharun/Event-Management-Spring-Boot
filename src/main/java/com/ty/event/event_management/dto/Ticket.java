package com.ty.event.event_management.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int ticketid;
	
	
	
	
	
	
	
	
}
