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

import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.service.EventDetailsService;
import com.ty.event.event_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("eventdetails")
public class EventDetailsController {

	@Autowired
	private EventDetailsService evService;

	@ApiOperation(value = "saveEventDetails", notes = "it is used to save the eventdetails")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method not allowed") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	
	
	public ResponseEntity<ResponseStructure<EventDetails>> saveEventDetails(@RequestBody EventDetails eventDetails,@RequestParam int id){
		return evService.saveEventDetails(eventDetails,id);
	}

	@ApiOperation(value = "updateEventDetails", notes = "it is used to update the EventDetails")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method not allowed") })

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	

	
	public ResponseEntity<ResponseStructure<EventDetails>> updateEventDetails(@RequestBody EventDetails eventDetails,@RequestParam int id){
		return evService.updateEventDetailsById(eventDetails,id);
	}

	@ApiOperation(value = "getEventDetailsById", notes = "it is used to get the eventdetails by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method not allowed") })

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<EventDetails>> getEventDetailsById(@RequestParam int id){
		return evService.getEventDetailsById(id);
	}
	@ApiOperation(value = "deleteEventDetails", notes = "it is used to delete the eventdetails by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found") ,@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method not allowed")})

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<EventDetails>> deleteEventDetailsById(@PathVariable int id){
		return evService.deleteEventDetailsById(id);
	}
	
	
	@ApiOperation(value = "saveEventDetails", notes = "it is used to save the eventdetails")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })



	
	@PostMapping("detials")
	public ResponseEntity<ResponseStructure<EventDetails>> saveEventDetailsID(@RequestParam int edid,@RequestParam int ehid){
		return evService.saveEventDetailsID(edid, ehid);
		
	}


}
