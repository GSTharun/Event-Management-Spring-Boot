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
	
	public EventDetails saveEvent(EventDetails eventDetails) {
		return repository.save(eventDetails);
	}
	
	public EventDetails updateEvent(EventDetails eventDetails) {
		return repository.save(eventDetails);
	}
	
	public EventDetails getEventById(int id){
		Optional<EventDetails>optional= repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}
	
	public void deleteEvent(EventDetails eventDetails) {
		repository.delete(eventDetails);
	}

}
