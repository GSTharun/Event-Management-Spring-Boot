package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.EventHall;
import com.ty.event.event_management.repository.EventHallRepository;

@Repository
public class EventHallDao {

	@Autowired
	private EventHallRepository repository;

	public EventHall saveEventHall(EventHall eventHall) {
		return repository.save(eventHall);
	}

	public EventHall updateEventHall(EventHall eventHall) {
		return repository.save(eventHall);
	}

	public EventHall getEventHallById(int id) {
		Optional<EventHall> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public String deleteEventHall(int id) {
		repository.deleteById(id);
		return "deleted";
	}

}
