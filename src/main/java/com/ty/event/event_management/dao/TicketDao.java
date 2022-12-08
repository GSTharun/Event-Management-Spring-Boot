package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Ticket;
import com.ty.event.event_management.repository.TicketRepository;

@Repository
public class TicketDao {

	@Autowired
	private TicketRepository ticketRepository;

	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Optional<Ticket> getTicketById(int id) {
		Optional<Ticket> optional = ticketRepository.findById(id);

		if (optional.isPresent()) {
		 optional.get();
		}
		return optional;
	}

	public void deleteTicket(Ticket ticket) {

		ticketRepository.delete(ticket);

	}

}
