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

import com.ty.event.event_management.dto.Menu;
import com.ty.event.event_management.service.MenuService;
import com.ty.event.event_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("menu")
public class MenuController {
	
	@Autowired
	private MenuService service;
	
	@ApiOperation(value="Save Menu",notes="Its is used to save Menu")
	@ApiResponses(value= {@ApiResponse(code=201,message="Created"),
			@ApiResponse(code=500,message="Internal server Error"),
			@ApiResponse(code=404,message = "Not Found")})
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@Valid @RequestBody Menu menu)
	{
		return service.saveMenu(menu);
	}
	
	@ApiOperation(value="update Menu",notes="Its is used to update Menu")
	@ApiResponses(value= {@ApiResponse(code=201,message="Created"),
			@ApiResponse(code=500,message="Internal server Error"),
			@ApiResponse(code=404,message = "Not Found")})
	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@Valid @RequestBody Menu menu,@RequestParam int id)
	{
		return service.updateMenu(menu, id);
	}
	
	@ApiOperation(value="fetch Menu",notes="Its is used to fetch Menu")
	@ApiResponses(value= {@ApiResponse(code=201,message="Created"),
			@ApiResponse(code=500,message="Internal server Error")})
	@GetMapping
	public ResponseEntity<ResponseStructure<Menu>> fetchMenuById(@Valid @RequestParam int id)
	{
		return service.findMenuById(id);
	}
	
	@ApiOperation(value="delete Menu",notes="Its is used to delete Menu")
	@ApiResponses(value= {@ApiResponse(code=201,message="Created"),
			@ApiResponse(code=500,message="Internal server Error")})
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenuById(@Valid @PathVariable int id)
	{
		return service.deleteMenuById(id);
	}

}
