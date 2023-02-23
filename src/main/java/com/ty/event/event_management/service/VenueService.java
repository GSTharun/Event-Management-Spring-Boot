package com.ty.event.event_management.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.AdminDao;
import com.ty.event.event_management.dao.EventDetailsDao;
import com.ty.event.event_management.dao.EventHallsDao;
import com.ty.event.event_management.dao.UserDao;
import com.ty.event.event_management.dao.VenueDao;
import com.ty.event.event_management.dto.Admin;
import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.dto.EventHalls;
import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.dto.Venue;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToDelete;
import com.ty.event.event_management.sendemail.SendEmail;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class VenueService {

	@Autowired
	private EventHallsDao eventHallsDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventDetailsDao eventDetailsDao;

	@Autowired
	private SendEmail sendEmail;

	public static final Logger logger = Logger.getLogger(VenueService.class);

	public ResponseEntity<ResponseStructure<Venue>> sendEmail(int uid, int edid,int ehid) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<Venue>();
		ResponseEntity<ResponseStructure<Venue>> responseEntity = new ResponseEntity<ResponseStructure<Venue>>(
				responseStructure, HttpStatus.OK);
		// Optional<User> user= userDao.getUserById(id);
		User user = userDao.getUserById(uid).get();
		EventDetails eventDetails = eventDetailsDao.getEventById(edid);
		EventHalls eventHalls = eventHallsDao.getEventHallsById(ehid).get();
		if (user != null) {
			String body = "User id: " + user.getUserid() + "\nUser name:" + user.getName() + "\nUser phone: "
					+ user.getPhoneno() + "\nEvent Title: " + eventDetails.getEventTitle() + "\nEvent Address: "
					+ eventDetails.getAddress() + "\nEvent Date: " + eventDetails.getEventDate() + "\nEvent Duration: "
					+ eventDetails.getDuration() + "\nEvent Cost: " + eventDetails.getTotalcost() + "\nEvent Hall Name: "
					+ eventHalls.getHallname() ;
			sendEmail.sendMail(user.getEmail(), body, "Your Event Details as been confirmed");
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("Email Sent " + user.getEmail());
			logger.debug("Data Saved");
		} else {
			throw new NoSuchIdFoundException();
		}
		return responseEntity;
	}

}
