package com.ty.event.event_management.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.AdminDao;
import com.ty.event.event_management.dao.AgentDao;
import com.ty.event.event_management.dao.EventHallsDao;
import com.ty.event.event_management.dto.Admin;
import com.ty.event.event_management.dto.Agent;
import com.ty.event.event_management.dto.EventHalls;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToDelete;
import com.ty.event.event_management.exception.NoSuchIdFoundToUpdate;
import com.ty.event.event_management.util.ResponseStructure;



@Service
public class AgentService {

	@Autowired
	private AgentDao agentdao;

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private EventHallsDao eventHallsDao;
	
	public static final Logger logger = Logger.getLogger(AddressService.class);


	public ResponseEntity<ResponseStructure<Agent>> saveAgent(Agent agent, int aid,int ehid) {
		ResponseEntity<ResponseStructure<Agent>> responseEntity;
		ResponseStructure<Agent> responseStructure = new ResponseStructure<Agent>();
		Optional<Admin> admin = adminDao.getAdminById(aid);
		Optional<EventHalls> eventhall = eventHallsDao.getEventHallsById(ehid);
		if (admin.isPresent() && eventhall.isPresent()) {
			admin.get().getAgents().add(agent);
			agent.setEventHalls(eventhall.get());
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Data saved");
			responseStructure.setData(agentdao.saveAgent(agent));
			logger.debug("Data Saved");
		} else {
			throw new NoSuchIdFoundException();
		}
		return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Agent>> updateAgent(Agent agent, int id) {
		ResponseEntity<ResponseStructure<Agent>> responseEntity;
		ResponseStructure<Agent> responseStructure = new ResponseStructure<Agent>();
		Optional<Agent> optional = agentdao.getAgentById(id);
		if (optional.isPresent()) {
			agent.setAgentid(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(agentdao.saveAgent(agent));
			logger.info("Data Updated");
			return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchIdFoundToUpdate("No Such Id Found To Update");
		}
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
		} else {
		logger.fatal("Data Not Found");	
			throw new NoSuchIdFoundException("No Such Id Found");
		}
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
			logger.warn("Data Deleted");
			return new ResponseEntity<ResponseStructure<Agent>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchIdFoundToDelete("No Such Id Found To Delete");
		}

	}

}
