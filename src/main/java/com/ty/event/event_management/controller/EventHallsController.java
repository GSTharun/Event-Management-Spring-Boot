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

import com.ty.event.event_management.dto.EventHalls;
import com.ty.event.event_management.service.EventHallsService;
import com.ty.event.event_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("eventhalls")
public class EventHallsController {
	
	@Autowired
	private EventHallsService eventHallsService;

	@ApiOperation(value = "saveEventHall", notes = "it is used to save the eventhall")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<EventHalls>> saveEventHall(@Valid @RequestBody EventHalls eventHalls) {
		return eventHallsService.saveEventHalls(eventHalls);
	}

	@ApiOperation(value = "updateEventHall", notes = "it is used to update the eventhall")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<EventHalls>> updateEventHall(@Valid @RequestBody EventHalls eventHall,
			@RequestParam int id) {
		return eventHallsService.updateEventHalls(eventHall, id);
	}

	@ApiOperation(value = "getEventHallById", notes = "it is used to get the EventHall by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<EventHalls>> getEventHallById(@Valid @RequestParam int id) {
		return eventHallsService.getEventHallsById(id);
	}

	@ApiOperation(value = "deleteEventHall", notes = "it is used to delete the eventhall by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<EventHalls>> deleteEventHallById(@Valid @PathVariable int id) {
		return eventHallsService.deleteEventHallsById(id);
	}

}
