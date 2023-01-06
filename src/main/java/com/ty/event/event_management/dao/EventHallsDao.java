package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.EventHalls;
import com.ty.event.event_management.repository.EventHallsRepository;


@Repository
public class EventHallsDao {
	
	@Autowired
	private EventHallsRepository eventHallsRepository;
	
	public EventHalls saveEventHalls(EventHalls eventHalls) {
		return eventHallsRepository.save(eventHalls);
	}
	
	public EventHalls updateEventHalls(EventHalls eventHalls) {
		return eventHallsRepository.save(eventHalls);
	}
	
	public Optional<EventHalls> getEventHallsById(int id){
		return eventHallsRepository.findById(id);
	}
	
	public void deleteEventHalls(EventHalls eventHalls) {
		eventHallsRepository.delete(eventHalls);
	}
	

}
