package com.ty.event.event_management.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.EventHalls;
import com.ty.event.event_management.repository.EventDetailsRepository;
import com.ty.event.event_management.repository.EventHallsRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EventHallsControllerTest {
	@Autowired
	EventHallsRepository eventHallsRepository;

	@Test
	@Order(1)
	void testSaveEventHall() {
		EventHalls eventHalls=new EventHalls();
		eventHalls.setHallname("Abc party");
		eventHalls.setPhoneno(123456);
		eventHalls.setLocation("Jayanagar");
		eventHalls.setCost(150000);
		eventHallsRepository.save(eventHalls);
		assertNotNull(eventHallsRepository.findById(1).get());
	}

	@Test
	void testUpdateEventHall() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEventHallById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteEventHallById() {
		fail("Not yet implemented");
	}

}
