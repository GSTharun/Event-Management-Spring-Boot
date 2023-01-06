package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Agent;
import com.ty.event.event_management.repository.AgentRepository;


@Repository
public class AgentDao {
	
	@Autowired
	private AgentRepository agentRepository;
	
	public Agent saveAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	public Agent updateAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	public Optional<Agent> getAgentById(int id) {
		return agentRepository.findById(id);
	}

	public void deleteAgent(Agent agent) {
		agentRepository.delete(agent);
	}

}
