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

import com.ty.event.event_management.dto.Agent;
import com.ty.event.event_management.service.AgentService;
import com.ty.event.event_management.util.ResponseStructure;

@RestController
@RequestMapping("agent")
public class AgentController {

	
	@Autowired
	private AgentService agentService;

	@PostMapping
	ResponseEntity<ResponseStructure<Agent>> saveAgent(@RequestBody Agent agent) {
		return agentService.saveAgent(agent);
	}

	@PutMapping
	ResponseEntity<ResponseStructure<Agent>> updateAgent(@RequestBody Agent agent) {
		return agentService.updateAgent(agent);
	}

	@GetMapping
	ResponseEntity<ResponseStructure<Agent>> getAgentById(@RequestParam int id) {
		return agentService.getAgentById(id);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<ResponseStructure<Agent>> deleteAgentById(@PathVariable int id) {
		return agentService.deleteAgentById(id);
	}

}
