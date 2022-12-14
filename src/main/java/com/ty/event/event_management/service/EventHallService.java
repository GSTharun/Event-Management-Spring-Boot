package com.ty.event.event_management.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.AdminDao;
import com.ty.event.event_management.dao.EventDetailsDao;
import com.ty.event.event_management.dao.EventHallDao;
import com.ty.event.event_management.dto.Admin;
import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.dto.EventHall;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.UnableToUpdateException;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class EventHallService {

	@Autowired
	private EventHallDao dao;
	
	@Autowired
	private EventDetailsDao eventDetailsDao;
	
	@Autowired
	AdminDao adminDao;

	public ResponseEntity<ResponseStructure<EventHall>> saveEventHall(int aid,int edid,int ehid) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		Optional<EventDetails> optional= eventDetailsDao.getEventDetailsById(edid);
		EventDetails details;
		if(optional.isPresent()) {
			details=optional.get();
		}else {
			details=null;
		}
		
		Optional<Admin> optional2=adminDao.getAdminById(aid);
		Admin admin;
		if(optional2.isPresent()) {
			admin=optional2.get();
		}else {
			admin=null;
		}
		
		if(details!=null && admin!=null) {
			
		details.setEvHall(admin.getEventHalls().get(ehid-1));
		responseStructure.setMessage("Data Saved");
		responseStructure.setData(dao.saveEventHall(admin.getEventHalls().get(ehid-1)));
//		eventDetailsDao.updateEventDetails(details);
		}else {
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
		}
		throw new UnableToUpdateException("No Such Id Found To Update");

	}

	public ResponseEntity<ResponseStructure<EventHall>> getEventHallById(int id) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		Optional<EventHall> optional = dao.getEventHallById(id);
		if (optional.isPresent()) {
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
