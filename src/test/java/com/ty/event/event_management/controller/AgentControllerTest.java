package com.ty.event.event_management.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.Agent;
import com.ty.event.event_management.repository.AgentRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AgentControllerTest {
	@Autowired
	AgentRepository agentRepository;

	@Test
	@Order(1)
	void testSaveAgent() {
		Agent agent=new Agent();
		agent.setAgentname("arun");
		agent.setAgentemail("ar@345");
		agent.setPhone(789);
		assertNotNull(agentRepository.findById(1).get());
	}

	@Test
	@Order(2)
	void testUpdateAgent() {
		Agent agent=agentRepository.findById(1).get();
		agent.setPhone(741);
		agentRepository.save(agent);
	}

	@Test
	@Order(3)
	void testGetAgentById() {
		Agent agent=agentRepository.findById(1).get();
		assertNotEquals("arun", agent.getAgentname());
	}

	@Test
	void testDeleteAgentById() {
		agentRepository.deleteById(1);
	}

}
