package com.ty.event.event_management.dto;

import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


import com.ty.event.event_management.util.AesEncryption;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private long phoneno;
	@Email
	private String email;
	@NotNull
	@Convert(converter = AesEncryption.class)
	private String password;
	@NotNull
	private String gender;
	@NotNull
	private String dob;

	@OneToMany
	private List<EventDetails> eventDetails;

}
