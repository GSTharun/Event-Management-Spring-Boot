package com.ty.event.event_management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.service.UserService;
import com.ty.event.event_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "saveUser", notes = "it is used to save the user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<ResponseStructure<User>> saveUser(@Valid @RequestBody User user) {
		return userService.saveUser(user);
	}

	@ApiOperation(value = "updateUser", notes = "it is used to update the user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<ResponseStructure<User>> updateUser(@Valid @RequestBody User user, @RequestParam String id) {
		return userService.updateUser(user, id);
	}

	@ApiOperation(value = "getUserById", notes = "it is used to get the user by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<ResponseStructure<User>> getUserById(@Valid @RequestParam String id) {
		return userService.getUserById(id);
	}

	@ApiOperation(value = "deleteUser", notes = "it is used to delete the user by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<ResponseStructure<User>> deleteUserById(@Valid @PathVariable String id) {
		return userService.deleteUserById(id);
	}
	@PatchMapping
	public ResponseEntity<ResponseStructure<String>> validateUserByEmailAndPassword(@RequestParam String email,String password) {
		return userService.validateUserByEmailAndPassword(email, password);
	}
}
