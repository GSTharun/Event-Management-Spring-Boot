package com.ty.event.event_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping
	ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@GetMapping
	ResponseEntity<ResponseStructure<User>> getUserById(@RequestParam int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<ResponseStructure<User>> deleteUserById(@PathVariable int id) {
		return userService.deleteUserById(id);
	}

}
