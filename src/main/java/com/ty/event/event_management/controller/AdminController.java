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

import com.ty.event.event_management.dto.Admin;
import com.ty.event.event_management.service.AdminService;
import com.ty.event.event_management.util.ResponseStructure;
@RestController
@RequestMapping("admin")
public class AdminController {

	

	@Autowired
	private AdminService adminService;

	@PostMapping
	ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@PutMapping
	ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin, @RequestParam int id) {
		return adminService.updateAdmin(admin, id);
	}

	@GetMapping
	ResponseEntity<ResponseStructure<Admin>> getAdminById(@RequestParam int id) {
		return adminService.getAdminById(id);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<ResponseStructure<Admin>> deleteAdminById(@PathVariable int id) {
		return adminService.deleteAdminById(id);
}
}
