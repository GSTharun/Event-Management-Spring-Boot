package com.ty.event.event_management.dto;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EventDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	@NotNull
	private String eventTitle;
	@NotNull
	private String address;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime eventDate;
	@NotNull
	private String duration;
	@NotNull
	private String entertainment;
	@NotNull
	private double totalcost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Menu menu;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private EventHalls eventHalls;

}
