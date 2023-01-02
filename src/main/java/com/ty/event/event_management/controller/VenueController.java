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

import com.ty.event.event_management.dto.Venue;
import com.ty.event.event_management.service.VenueService;
import com.ty.event.event_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("venue")
public class VenueController {

	@Autowired
	private VenueService service;

	@ApiOperation(value = "saveVenue", notes = "it is used to save the venue")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method not allowed") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<ResponseStructure<Venue>> saveVenue(@RequestBody Venue venue,@RequestParam int id) {
		return service.saveVenue(venue,id);
	}

	@ApiOperation(value = "updateVenu", notes = "it is used to update the venu")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method not allowed") })

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<ResponseStructure<Venue>> updateVenue(@RequestBody Venue venue,@RequestParam int id) {
		return service.updateVenue(venue,id);
	}

	@ApiOperation(value = "getVenuById", notes = "it is used to get the venu by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method not allowed") })

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<ResponseStructure<Venue>> getVenueById(@RequestParam int id) {
		return service.getVenueById(id);
	}

	@ApiOperation(value = "deleteVenu", notes = "it is used to delete the venu by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found") ,@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method not allowed")})

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<ResponseStructure<Venue>> deleteVenueById(@PathVariable int id) {
		return service.deleteVenueById(id);
	}

}
