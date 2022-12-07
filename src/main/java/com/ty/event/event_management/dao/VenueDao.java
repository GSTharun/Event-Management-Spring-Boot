package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Venue;
import com.ty.event.event_management.repository.VenueRepository;

@Repository
public class VenueDao {

	@Autowired
	private VenueRepository repository;

	public Venue saveVenue(Venue venue) {
		return repository.save(venue);
	}

	public Venue updateVenue(Venue venue) {
		return repository.save(venue);
	}

	public Venue getVenueById(int id) {
		Optional<Venue> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deleteVenue(int id) {
		repository.deleteById(id);
		return "deleted";
	}

}
