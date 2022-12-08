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

import com.ty.event.event_management.dto.Venue;
import com.ty.event.event_management.service.VenueService;
import com.ty.event.event_management.util.ResponseStructure;

@RestController
@RequestMapping("venue")
public class VenueController {

	@Autowired
	private VenueService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<Venue>> saveVenue(@RequestBody Venue venue) {
		return service.saveVenue(venue);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Venue>> updateVenue(@RequestBody Venue venue) {
		return service.updateVenue(venue);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Venue>> getVenueById(@RequestParam int id) {
		return service.getVenueById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Venue>> deleteVenueById(@PathVariable int id) {
		return service.deleteVenueById(id);
	}

}
