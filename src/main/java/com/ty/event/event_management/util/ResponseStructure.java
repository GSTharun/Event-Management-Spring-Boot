package com.ty.event.event_management.util;

<<<<<<< HEAD
import java.util.Optional;

import com.ty.event.event_management.dto.User;
=======
import org.springframework.http.HttpStatus;
>>>>>>> 45b9b7b337fffc80e3e931212aed2bfeaa1eb016

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStructure <T>{
	private int status;
	private String message;
	private T data;

}
