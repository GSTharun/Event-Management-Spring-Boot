package com.ty.event.event_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("staff")
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	@ApiOperation(value = "saveStaff", notes = "it is used to save the staff")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	
	ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}

	@ApiOperation(value = "updateStaff", notes = "it is used to update the staff")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	
	ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff,@RequestParam int id) {
		return staffService.updateStaff(staff,id);
	}

	@ApiOperation(value = "getStaffById", notes = "it is used to get the staff by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })

	ResponseEntity<ResponseStructure<Staff>> getStaffById(@RequestParam int id) {
		return staffService.getStaffById(id);
	}

	@ApiOperation(value = "deleteStaff", notes = "it is used to delete the staff by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })

	ResponseEntity<ResponseStructure<Staff>> deleteStaffById(@PathVariable int id) {
		return staffService.deleteStaffById(id);
	}

}
