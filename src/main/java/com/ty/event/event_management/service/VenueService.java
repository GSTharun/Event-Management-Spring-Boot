package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.VenueDao;
import com.ty.event.event_management.dto.Venue;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.UnableToUpdateException;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class VenueService {

	@Autowired
	private VenueDao dao;

	public ResponseEntity<ResponseStructure<Venue>> saveVenue(Venue venue) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<Venue>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data Saved");
		responseStructure.setData(dao.saveVenue(venue));
		return new ResponseEntity<ResponseStructure<Venue>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Venue>> updateVenue(Venue venue) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<Venue>();
		Optional<Venue> optional = dao.getVenueById(venue.getVenueid());
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Updated");
			responseStructure.setData(dao.updateVenue(venue));
			return new ResponseEntity<ResponseStructure<Venue>>(responseStructure, HttpStatus.OK);
		}
		throw new UnableToUpdateException("No Such Id Found To Update");

	}

	public ResponseEntity<ResponseStructure<Venue>> getVenueById(int id) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<Venue>();
		Optional<Venue> optional = dao.getVenueById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Feteched");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Venue>>(responseStructure, HttpStatus.OK);
		}
		throw new NoSuchIdFoundException("No Such Id Found");

	}

	public ResponseEntity<ResponseStructure<Venue>> deleteVenueById(int id) {
		ResponseStructure<Venue> responseStructure = new ResponseStructure<>();
		Optional<Venue> optional = dao.getVenueById(id);
		if (optional.isPresent()) {
			dao.deleteVenue(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Deleted");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Venue>>(responseStructure, HttpStatus.OK);
		}
		throw new NoSuchIdFoundException("No Such Id Found To Delete");

	}

}
