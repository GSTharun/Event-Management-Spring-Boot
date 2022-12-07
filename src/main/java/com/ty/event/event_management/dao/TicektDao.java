package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Ticket;
import com.ty.event.event_management.repository.TicketRepository;

@Repository
public class TicektDao {

	@Autowired
	TicketRepository ticketRepository;

	public Ticket saveTiceket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Ticket updateTiceket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Ticket findTiceketById(int id) {
		Optional<Ticket> optional = ticketRepository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public void deleteTicektById(Ticket ticket) {

		ticketRepository.delete(ticket);

	}

}
