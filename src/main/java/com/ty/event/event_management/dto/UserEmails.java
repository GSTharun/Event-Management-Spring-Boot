package com.ty.event.event_management.dto;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ty.event.event_management.util.AESencription;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserEmails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Email
	@NotEmpty(message = "Email should not be empty")
	@Column(unique = true)
	private String userEmail;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private User user;
}
