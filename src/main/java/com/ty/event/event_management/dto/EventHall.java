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
public class EventHall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventhallid;
	@NotNull
	private String name;
	@NotNull
	private String location;
	@NotNull
	private long phone;

}
