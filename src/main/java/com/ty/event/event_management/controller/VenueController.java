package com.ty.event.event_management.controller;

import javax.validation.Valid;

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
	private VenueService venueService;

	@ApiOperation(value = "saveVenue", notes = "it is used to save the Venue")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Venue>> saveVenue(@Valid @RequestBody Venue venue, @RequestParam int aid,@RequestParam int edid) {
		return venueService.saveVenue(venue, aid,edid);
	}
	@ApiOperation(value = "updateVenue", notes = "it is used to update the Venue")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Venue>> updateEventDetails(@Valid @RequestBody Venue venue,@RequestParam int id) {
		return venueService.updateVenueById(venue, id);
	}
	@ApiOperation(value = "getVenueById", notes = "it is used to get the Venue by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Venue>> getEventDetailsById(@Valid @RequestParam int id) {
		return venueService.getVenueById(id);
	}

	@ApiOperation(value = "deleteVenue", notes = "it is used to delete the Venue by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Venue>> deleteVenueById(@Valid @PathVariable int id) {
		return venueService.deleteVenueById(id);
	}

}
