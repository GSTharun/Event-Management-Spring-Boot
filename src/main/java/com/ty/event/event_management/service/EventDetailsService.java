package com.ty.event.event_management.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.EventDetailsDao;
import com.ty.event.event_management.dao.EventHallsDao;
import com.ty.event.event_management.dao.UserDao;
import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.dto.EventHalls;
import com.ty.event.event_management.dto.Items;
import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToDelete;
import com.ty.event.event_management.exception.NoSuchIdFoundToUpdate;
import com.ty.event.event_management.util.ResponseStructure;



@Service
public class EventDetailsService {

	@Autowired
	private EventDetailsDao eventDetailsDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventHallsDao eventHallsDao;

	public static final Logger logger = Logger.getLogger(EventDetailsService.class);


	public ResponseEntity<ResponseStructure<EventDetails>> saveEventDetails(EventDetails eventDetails, int uid,int ehid) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<User> user = userDao.getUserById(uid);
		Optional<EventHalls> eventhall = eventHallsDao.getEventHallsById(ehid);
		if(user.isPresent() && eventhall.isPresent()) {
			user.get().getEventDetails().add(eventDetails);
			eventhall.get().getEventDetails().add(eventDetails);
			eventDetails.setEventHalls(eventhall.get());
			List<Items> list = eventDetails.getMenu().getItems();
			double totalcost=0;
			for(Items items:list)
			{
				totalcost = totalcost+(items.getCost()*items.getQuantity());
			}
			totalcost=(totalcost *0.18)+totalcost;
			eventDetails.setTotalcost(totalcost);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("saved");
			responseStructure.setData(eventDetailsDao.saveEvent(eventDetails));
			logger.debug("Data Saved");
		} else {
			throw new NoSuchIdFoundException();
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<EventDetails>> updateEventDetailsById(EventDetails eventDetails, int eid) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = eventDetailsDao.getEventById(eid);
		if (optional.isPresent()) {
			eventDetails.setEventId(eid);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(eventDetailsDao.updateEvent(eventDetails));
			logger.info("Data Updated");
		} else {
			throw new NoSuchIdFoundToUpdate("No Such Id Found To Update");
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<EventDetails>> getEventDetailsById(int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = eventDetailsDao.getEventById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			System.out.println(optional.get().toString());
			responseStructure.setData(optional.get());

		} else {
			logger.fatal("Data Not Found");
			throw new NoSuchIdFoundException("No SUch Id Found");
		}
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<EventDetails>> deleteEventDetailsById(int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = eventDetailsDao.getEventById(id);
		if (optional.isPresent()) {
			eventDetailsDao.deleteEvent(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(optional.get());
			return responseEntity;

		} else {
			logger.warn("Data Deleted");
			throw new NoSuchIdFoundToDelete("No Such Id Found To Delete");
		}
	}

}
