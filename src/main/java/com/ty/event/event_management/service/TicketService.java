package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.TicketDao;
import com.ty.event.event_management.dto.Ticket;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.UnableToUpdateException;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;

	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket) {
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("DataSaved");
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Ticket>> updateTicketById(Ticket ticket) {
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		Optional<Ticket> optional = ticketDao.getTicketById(ticket.getTicketid());
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(ticketDao.updateTicket(ticket));
			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.OK);
		}

		throw new UnableToUpdateException("No Such Id Found To Update");

	}

	public ResponseEntity<ResponseStructure<Ticket>> getTicketById(int id) {
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		Optional<Ticket> optional = ticketDao.getTicketById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data fetched");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.OK);
		}
			throw new NoSuchIdFoundException("No Such Id Found");

	}

	public ResponseEntity<ResponseStructure<Ticket>> deleteTicketById(int id) {
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		Optional<Ticket> optional = ticketDao.getTicketById(id);
		if (optional.isPresent()) {
			ticketDao.deleteTicket(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted sucessfully");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure, HttpStatus.OK);
		}
			throw new NoSuchIdFoundException("No Such Found To Delete");
		

	}

}
