package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.AgentDao;
import com.ty.event.event_management.dto.Agent;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class AgentService {

	@Autowired
	private AgentDao agentdao;

	public ResponseEntity<ResponseStructure<Agent>> saveAgent(Agent agent) {
		ResponseEntity<ResponseStructure<Agent>> responseEntity;
		ResponseStructure<Agent> responseStructure = new ResponseStructure<Agent>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data saved");
		responseStructure.setData(agentdao.saveAgent(agent));
		return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Agent>> updateAgent(Agent agent) {
		ResponseEntity<ResponseStructure<Agent>> responseEntity;
		ResponseStructure<Agent> responseStructure = new ResponseStructure<Agent>();
		Optional<Agent> optional = agentdao.getAgentById(agent.getAgentid());
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(agentdao.saveAgent(agent));
			return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.OK);
		}
		throw null;
	}

	public ResponseEntity<ResponseStructure<Agent>> getAgentById(int id) {
		ResponseEntity<ResponseStructure<Agent>> responseEntity;
		ResponseStructure<Agent> responseStructure = new ResponseStructure<Agent>();
		Optional<Agent> optional = agentdao.getAgentById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data found");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.OK);
		}
		throw null;
	}

	public ResponseEntity<ResponseStructure<Agent>> deleteAgentById(int id) {
		ResponseEntity<ResponseStructure<Agent>> responseEntity;
		ResponseStructure<Agent> responseStructure = new ResponseStructure<Agent>();
		Optional<Agent> optional = agentdao.getAgentById(id);
		if (optional.isPresent()) {
			   agentdao.deleteAgent(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.OK);
		}

		throw null;

	}

}
