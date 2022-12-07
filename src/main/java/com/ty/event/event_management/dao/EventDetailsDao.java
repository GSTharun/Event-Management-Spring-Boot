package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.repository.EventDetailsRepository;

@Repository
public class EventDetailsDao {
	@Autowired
	private EventDetailsRepository repository;

	public EventDetails saveEventDetails(EventDetails eventDetails) {
		return repository.save(eventDetails);
	}

	public EventDetails updateEventDetails(EventDetails eventDetails) {
		return repository.save(eventDetails);
	}

	public EventDetails getEventDetailsById(int id) {
		Optional<EventDetails> evOptional=repository.findById(id);
		if(evOptional.isEmpty()) {
			return null;

		}else {
			return evOptional.get();
		}
	}
	public void deleteEventDetails(EventDetails eventDetails) {
		repository.delete(eventDetails);
	}
}
