package com.ty.event.event_management.util;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure <T>{
	private int status;
	private String message;
	private T data;

}
