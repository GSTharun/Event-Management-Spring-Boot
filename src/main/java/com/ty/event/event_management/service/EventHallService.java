package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.EventHallDao;
import com.ty.event.event_management.dto.EventHall;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.UnableToUpdateException;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class EventHallService {

	@Autowired
	private EventHallDao dao;

	public ResponseEntity<ResponseStructure<EventHall>> saveEventHall(EventHall eventHall) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data Saved");
		responseStructure.setData(dao.saveEventHall(eventHall));
		return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<EventHall>> updateEventHall(EventHall eventHall) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		Optional<EventHall> optional = dao.getEventHallById(eventHall.getEventhallid());
		if (optional.isPresent()) {
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
