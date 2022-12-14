package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.EventDetailsDao;
import com.ty.event.event_management.dao.EventHallDao;
import com.ty.event.event_management.dao.UserDao;
import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.dto.EventHall;
import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.UnableToUpdateException;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class EventDetailsService {
	@Autowired
	private EventDetailsDao evDetailsDao;
	
	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<EventDetails>> saveEventDetails(EventDetails eventDetails,int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
			Optional<User> optional=userDao.getUserById(id);
			User user;
			if(optional.isPresent()) {
				user=optional.get();
			}else {
				user=null;
			}
			if(user!=null) {
				user.getEventDetails().add(eventDetails);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("saved");
			responseStructure.setData(evDetailsDao.saveEventDetails(eventDetails));
			userDao.updateUser(user);
		
	}else {
		throw new NoSuchIdFoundException();
	}
			return responseEntity;
	}

	public ResponseEntity<ResponseStructure<EventDetails>> updateEventDetailsById(EventDetails eventDetails,int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = evDetailsDao.getEventDetailsById(id);
		if (optional.isPresent()) {
			eventDetails.setEventId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(evDetailsDao.updateEventDetails(eventDetails));

		} else {
			throw new UnableToUpdateException("No Such Id Found To Update");
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
			throw new NoSuchIdFoundException("No SUch Id Found");
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
		throw new NoSuchIdFoundException("No Such Id Found To Delete");
	}
}
