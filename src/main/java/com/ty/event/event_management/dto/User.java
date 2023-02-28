package com.ty.event.event_management.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.ty.event.event_management.util.AESencription;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	
	@Id
	@GenericGenerator(name = "id_generation", strategy = "com.ty.event.event_management.customeId.GeneratecustomeId")
	@GeneratedValue(generator = "id_generation")
	private String userid;
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	@Min(999999999)
	@Max(9999999999L)
	private long phoneno;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserEmails> emails;

	@Convert(converter=AESencription.class)
	@NotNull
	private String password;
	@NotNull
	private String gender;
	@NotNull
	private String dob;
	
	@OneToMany
	@JoinColumn(name = "userid")
	private List<EventDetails> eventDetails;

}
