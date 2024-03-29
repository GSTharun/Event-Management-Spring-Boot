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

import com.ty.event.event_management.dto.Agent;
import com.ty.event.event_management.service.AgentService;
import com.ty.event.event_management.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("agent")
public class AgentController {

	@Autowired
	private AgentService agentService;


	@ApiOperation(value = "saveAgent", notes = "it is used to save the Agent")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<ResponseStructure<Agent>> saveAgent(@Valid @RequestBody Agent agent,@RequestParam int aid,@RequestParam int ehid) {
		return agentService.saveAgent(agent,aid,ehid);
	}

	@ApiOperation(value = "updateAgent", notes = "it is used to update the Agent")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<ResponseStructure<Agent>> updateAgent(@Valid @RequestBody Agent agent,@RequestParam int id) {
		return agentService.updateAgent(agent,id);
	}

	@ApiOperation(value = "getAgentById", notes = "it is used to get the Agent by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<ResponseStructure<Agent>> getAgentById(@Valid @RequestParam int id) {
		return agentService.getAgentById(id);
	}

	@ApiOperation(value = "deleteAgent", notes = "it is used to delete the Agent by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found"),@ApiResponse(code = 403, message = "Forbidden"),@ApiResponse(code = 405, message = "Method Not Allowed") })
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<ResponseStructure<Agent>> deleteAgentById(@Valid @PathVariable int id) {
		return agentService.deleteAgentById(id);
	}


}
