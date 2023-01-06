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
	
	public Optional<EventDetails> getEventById(int id){
		return repository.findById(id);
	}
	
	public void deleteEvent(EventDetails eventDetails) {
		repository.delete(eventDetails);
	}

}
