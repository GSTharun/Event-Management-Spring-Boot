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

	public Optional<EventHall> getEventHallById(int id) {
		return repository.findById(id);

	}

	public void deleteEventHall(EventHall eventHall) {
		repository.delete(eventHall);

	}

}
