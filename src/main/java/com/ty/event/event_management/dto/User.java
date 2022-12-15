package com.ty.event.event_management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.ty.event.event_management.util.AESencription;

import lombok.Data;
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
	@NotNull
	private String email;
	@Convert(converter = AESencription.class)
	@NotNull
	private String password;
	@NotNull
	private String gender;
	@NotNull
	private String dob;

	@OneToMany
	private List<EventDetails> eventDetails;

}
