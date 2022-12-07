package com.ty.event.event_management.dto;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Agent {
	@NotNull
private String agentname;
	@NotNull
private String agentemail;
	@NotNull
private long phone;
}
