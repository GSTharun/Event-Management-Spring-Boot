package com.ty.event.event_management.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.Address;
import com.ty.event.event_management.repository.AddressRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AddressControllerTest {
	@Autowired
	AddressRepository addressRepository;

	@Test
	@Order(1)
	void testSaveAddress() {
		Address address=new Address();
		address.setCityname("Banglore");
		address.setLocation("Banashankari");
		addressRepository.save(address);
		assertNotNull(addressRepository.findById(1).get());
	}

	@Test
	@Order(2)
	void testUpdateAddress() {
		Address address=addressRepository.findById(1).get();
		address.setLocation("Jayanagar");
		addressRepository.save(address);
		}

	@Test
	@Order(3)
	void testGetAddressById() {
		Address address=addressRepository.findById(1).get();
		assertEquals("Jayanagar", address.getLocation());
	}

	@Test
	@Order(4)
	void testDeleteAddressById() {
		addressRepository.deleteById(1);
	}

}
