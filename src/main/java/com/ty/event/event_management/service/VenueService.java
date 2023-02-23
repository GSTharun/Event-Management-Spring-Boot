package com.ty.event.event_management.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.AdminDao;
import com.ty.event.event_management.dao.VenueDao;
import com.ty.event.event_management.dto.Admin;
import com.ty.event.event_management.dto.Venue;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToDelete;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class VenueService {

	@Autowired
	private VenueDao venueDao;

	@Autowired
	private AdminDao adminDao;

	public static final Logger logger = Logger.getLogger(VenueService.class);

	public ResponseEntity<ResponseStructure<Venue>> saveVenue(Venue venue,int aid) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<Venue>();
		ResponseEntity<ResponseStructure<Venue>> responseEntity = new ResponseEntity<ResponseStructure<Venue>>(
				responseStructure, HttpStatus.OK);
		Optional<Admin> admin = adminDao.getAdminById(aid);
		if (admin.isPresent()) {
			venue.setAdmin(admin.get());
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setData(venueDao.saveVenue(venue));
			responseStructure.setMessage("Saved");
			logger.debug("Data Saved");
		} else {
			throw new NoSuchIdFoundException();
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<Venue>> updateVenueById(Venue venue, int vid) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<Venue>();
		ResponseEntity<ResponseStructure<Venue>> responseEntity = new ResponseEntity<ResponseStructure<Venue>>(
				responseStructure, HttpStatus.OK);
		Optional<Venue> optional = venueDao.getVenueById(vid);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(venueDao.updateVenue(venue));
			logger.info("Data Updated");
		} else {
			throw new NoSuchIdFoundException("No Such Id Found To Update");
		}
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<Venue>> getVenueById(int id) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<Venue>();
		ResponseEntity<ResponseStructure<Venue>> responseEntity = new ResponseEntity<ResponseStructure<Venue>>(
				responseStructure, HttpStatus.OK);
		Optional<Venue> optional = venueDao.getVenueById(id);
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

	public ResponseEntity<ResponseStructure<Venue>> deleteVenueById(int id) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<Venue>();
		ResponseEntity<ResponseStructure<Venue>> responseEntity = new ResponseEntity<ResponseStructure<Venue>>(
				responseStructure, HttpStatus.OK);
		Optional<Venue> optional = venueDao.getVenueById(id);
		if (optional.isPresent()) {
			venueDao.deleteVenue(optional.get());
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
