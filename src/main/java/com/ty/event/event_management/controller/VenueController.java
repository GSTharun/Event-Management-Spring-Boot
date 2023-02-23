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

	@ApiOperation(value = "deleteVenue", notes = "it is used to delete the Venue by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PatchMapping
	public ResponseEntity<ResponseStructure<Venue>> SendTocken(@Valid @RequestParam int uid, @RequestParam int edid,@RequestParam int ehid) {
		return venueService.sendEmail(uid, edid,ehid);
	}

}
