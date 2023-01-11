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

import com.ty.event.event_management.dto.Items;
import com.ty.event.event_management.service.ItemsService;
import com.ty.event.event_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("items")
public class ItemsController {

	@Autowired
	private ItemsService service;

	@ApiOperation(value = "Save Items", notes = "Its is used to save items")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server Error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> saveItems(@Valid @RequestBody Items items) {
		return service.saveItems(items);
	}

	@ApiOperation(value = "update Items", notes = "Its is used to update Items")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server Error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseStructure<Items>> updateItems(@Valid @RequestBody Items items, @RequestParam int id) {
		return service.updateItems(items, id);
	}

	@ApiOperation(value = "fetch Items", notes = "Its is used to fetch Items")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server Error"),@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 405, message = "Method Not Allowed")  })
	@GetMapping
	public ResponseEntity<ResponseStructure<Items>> fetchItemsById(@Valid @RequestParam int id) {
		return service.findItemsById(id);
	}

	@ApiOperation(value = "delete Items", notes = "Its is used to delete Items")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server Error"),@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),
			@ApiResponse(code = 405, message = "Method Not Allowed")  })
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Items>> deleteItemsById(@Valid @PathVariable int id) {
		return service.deleteItemsById(id);
	}

}
