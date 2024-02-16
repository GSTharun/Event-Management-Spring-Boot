package com.ty.event.event_management.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.EventHallsDao;
import com.ty.event.event_management.dto.EventHalls;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToDelete;
import com.ty.event.event_management.exception.NoSuchIdFoundToUpdate;
import com.ty.event.event_management.util.ResponseStructure;



@Service
public class EventHallsService {

	@Autowired
	private EventHallsDao eventHallsDao;

	public static final Logger logger = Logger.getLogger(EventHallsService.class);

	public ResponseEntity<ResponseStructure<EventHalls>> saveEventHalls(EventHalls eventHalls) {
		ResponseEntity<ResponseStructure<EventHalls>> responseEntity;
		ResponseStructure<EventHalls> responseStructure = new ResponseStructure<EventHalls>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data saved");
		responseStructure.setData(eventHallsDao.saveEventHalls(eventHalls));
		logger.debug("Data Saved");
		return new ResponseEntity<ResponseStructure<EventHalls>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<EventHalls>> updateEventHalls(EventHalls eventHalls, int id) {
		ResponseEntity<ResponseStructure<EventHalls>> responseEntity;
		ResponseStructure<EventHalls> responseStructure = new ResponseStructure<EventHalls>();
		Optional<EventHalls> optional = eventHallsDao.getEventHallsById(id);
		if (optional.isPresent()) {
			eventHalls.setEventhallid(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(eventHallsDao.saveEventHalls(eventHalls));
			logger.info("Data Updated");
			return new ResponseEntity<ResponseStructure<EventHalls>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchIdFoundToUpdate("No Such Id Found To Update");
		}

	}

	public ResponseEntity<ResponseStructure<EventHalls>> getEventHallsById(int id) {
		ResponseEntity<ResponseStructure<EventHalls>> responseEntity;
		ResponseStructure<EventHalls> responseStructure = new ResponseStructure<EventHalls>();
		Optional<EventHalls> eventHalls = eventHallsDao.getEventHallsById(id);
		if (eventHalls.isPresent()) {
			eventHalls.get().getEventDetails();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data found");
			responseStructure.setData(eventHalls.get());
			return new ResponseEntity<ResponseStructure<EventHalls>>(responseStructure, HttpStatus.OK);
		}
		logger.fatal("Data Not Found");
		throw new NoSuchIdFoundException("No Such Id Found");
	}

	public ResponseEntity<ResponseStructure<EventHalls>> deleteEventHallsById(int id) {
		ResponseEntity<ResponseStructure<EventHalls>> responseEntity;
		ResponseStructure<EventHalls> responseStructure = new ResponseStructure<EventHalls>();
		Optional<EventHalls> optional = eventHallsDao.getEventHallsById(id);
		if (optional.isPresent()) {
			eventHallsDao.deleteEventHalls(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			logger.warn("Data Deleted");
			return new ResponseEntity<ResponseStructure<EventHalls>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchIdFoundToDelete("No Such ID Found To Delete");
		}
	}

}
