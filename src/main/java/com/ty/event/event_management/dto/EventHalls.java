package com.ty.event.event_management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EventHalls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventhallid;
	private String hallname;
	private String location;
	private long phoneno;
	private int cost;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

//	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)
	private List<EventDetails> eventDetails;

}
