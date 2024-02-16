package com.ty.event.event_management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Agent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agentid;
	@NotNull
	private String agentname;
	@Email
	private String agentemail;
	@NotNull
	@Min(999999999)
	@Max(9999999999L)
	private long phone;

	@OneToOne
	private EventHalls eventHalls;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Staff> staffs;

}
