package com.ty.event.event_management.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.Agent;
import com.ty.event.event_management.dto.EventDetails;
import com.ty.event.event_management.repository.EventDetailsRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EventDetailsControllerTest {

	@Autowired
	EventDetailsRepository eventDetailsRepository;

	@Test
	@Order(1)
	void testSaveEventDetails() {
		EventDetails eventDetails=new EventDetails();
		eventDetails.setEventTitle("BirthDay Party");
		eventDetails.setAddress("Jayanagar");
		eventDetails.setDuration("10 hours");
		eventDetails.setEventDate(LocalDateTime.now());
		eventDetails.setTotalcost(150000);
//eventDetails.setEventHalls("abc");
//		eventDetails.setMenu("veg");
	}

	@Test
	@Order(2)
	void testUpdateEventDetails() {
     EventDetails eventDetails=eventDetailsRepository.findById(1).get();
     eventDetails.setDuration("12 hours");
     eventDetailsRepository.save(eventDetails);
	}

	@Test
	@Order(3)
	void testGetEventDetailsById() {
		EventDetails eventDetails=eventDetailsRepository.findById(1).get();
		assertNotEquals("Jayanagar", eventDetails.getAddress());
	}

	@Test
	@Order(4)
	void testDeleteEventDetailsById() {
		eventDetailsRepository.deleteById(1);
	}

}
