package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.EventDetailsDao;
import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class EventDetailsService {
	@Autowired
	private EventDetailsDao evDetailsDao;

	public ResponseEntity<ResponseStructure<EventDetails>> saveEventDetails(EventDetails eventDetails) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(evDetailsDao.saveEventDetails(eventDetails));
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<EventDetails>> updateEventDetailsById(EventDetails eventDetails, int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = evDetailsDao.getEventDetailsById(id);
		if (optional.isPresent()) {
			optional.get();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(evDetailsDao.updateEventDetails(eventDetails));

		} else {
			throw null;
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<EventDetails>> getEventDetailsById(int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = evDetailsDao.getEventDetailsById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(optional.get());

		} else {
			throw null;
		}
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<EventDetails>> deleteEventDetailsById(int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = evDetailsDao.getEventDetailsById(id);
		if (optional.isPresent()) {
			evDetailsDao.deleteEventDetails(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw null;
	}
}
