package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.event.event_management.dto.Venue;
import com.ty.event.event_management.repository.VenueRepository;

@Repository
public class VenueDao {

	@Autowired
	private VenueRepository venueRepository;

	public Venue saveVenue(Venue venue) {
		return venueRepository.save(venue);
	}

	public Venue updateVenue(Venue venue) {
		return venueRepository.save(venue);
	}

	public Optional<Venue> getVenueById(int id) {
		return venueRepository.findById(id);
	}

	public void deleteVenue(Venue venue) {
		venueRepository.delete(venue);
	}

}
