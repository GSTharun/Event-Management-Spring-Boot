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

import com.ty.event.event_management.dto.Staff;
import com.ty.event.event_management.service.StaffService;
import com.ty.event.event_management.util.ResponseStructure;

@RestController
@RequestMapping("staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@PostMapping
	ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}

	@PutMapping
	ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff) {
		return staffService.updateStaff(staff);
	}

	@GetMapping
	ResponseEntity<ResponseStructure<Staff>> getStaffById(@RequestParam int id) {
		return staffService.getStaffById(id);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<ResponseStructure<Staff>> deleteStaffById(@PathVariable int id) {
		return staffService.deleteStaffById(id);
	}

}
