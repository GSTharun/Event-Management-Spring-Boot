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
			@ApiResponse(code = 404, message = "Not Found") })

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	ResponseEntity<ResponseStructure<Agent>> saveAgent(@RequestBody Agent agent) {
		return agentService.saveAgent(agent);
	}

	@ApiOperation(value = "updateAgent", notes = "it is used to update the Agent")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@PutMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	ResponseEntity<ResponseStructure<Agent>> updateAgent(@RequestBody Agent agent) {
		return agentService.updateAgent(agent);
	}

	@ApiOperation(value = "getAgentById", notes = "it is used to get the Agent by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internal server error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })

	ResponseEntity<ResponseStructure<Agent>> getAgentById(@RequestParam int id) {
		return agentService.getAgentById(id);
	}

	@ApiOperation(value = "deleteAgent", notes = "it is used to delete the Agent by id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "found"),
			@ApiResponse(code = 500, message = "internel server error"),
			@ApiResponse(code = 404, message = "Not Found") })

	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })

	ResponseEntity<ResponseStructure<Agent>> deleteAgentById(@PathVariable int id) {
		return agentService.deleteAgentById(id);
	}

}
