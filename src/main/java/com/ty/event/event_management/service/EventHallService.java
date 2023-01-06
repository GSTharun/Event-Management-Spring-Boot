package com.ty.event.event_management.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.AdminDao;
import com.ty.event.event_management.dao.EventDetailsDao;
import com.ty.event.event_management.dao.EventHallDao;
import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.dto.EventHall;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToUpdate;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class EventHallService {

	@Autowired
	private EventHallDao dao;
	
	@Autowired
	private EventDetailsDao eventDetailsDao;
	
	
	@Autowired
	AdminDao adminDao;

	public ResponseEntity<ResponseStructure<EventHall>> saveEventHall(int edid,int ehid) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		Optional<EventDetails> event= eventDetailsDao.getEventDetailsById(edid);
		Optional<EventHall> eventHall = dao.getEventHallById(ehid);
		
		if (event.isPresent()&& eventHall.isPresent()) {
			event.get().setEvHall(eventHall.get());	
			responseStructure.setMessage("Data Saved");
			responseStructure.setData(eventHall.get());
			eventDetailsDao.updateEventDetails(event.get());
		}
		else {
			throw new NoSuchIdFoundException();
		}
		return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<EventHall>> updateEventHall(EventHall eventHall,int id) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		Optional<EventHall> optional = dao.getEventHallById(id);
		if (optional.isPresent()) {
			eventHall.setEventhallid(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Updated");
			responseStructure.setData(dao.updateEventHall(eventHall));
			return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.OK);
		}else {
			throw new NoSuchIdFoundToUpdate("No Such Id Found To Update");
		}

	}

	public ResponseEntity<ResponseStructure<EventHall>> getEventHallById(int id) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		Optional<EventHall> optional = dao.getEventHallById(id);
		if (optional.isPresent()) {
			List<EventDetails> list=eventDetailsDao.getAllEvent();
			for (EventDetails eventDetails : list) {
				
				eventDetails.getEventTitle();
				eventDetails.getAddress();
				eventDetails.getEventDate();
				eventDetails.getDuration();
				eventDetails.getFoodRefreshment();
				eventDetails.getEventDate();
				
			}
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Fetched");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.OK);
		}
		throw new NoSuchIdFoundException("No Such Id Found");

	}

	public ResponseEntity<ResponseStructure<EventHall>> deleteEventHallById(int id) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		Optional<EventHall> optional = dao.getEventHallById(id);
		if (optional.isPresent()) {
			dao.deleteEventHall(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Deleted");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.OK);
		}
		throw new NoSuchIdFoundException("NO Such Id Found To Update");
	}

}
