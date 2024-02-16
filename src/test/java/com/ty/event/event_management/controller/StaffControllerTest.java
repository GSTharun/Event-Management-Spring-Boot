package com.ty.event.event_management.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.Staff;
import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.repository.StaffRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StaffControllerTest {
	@Autowired
	StaffRepository staffRepository;
	

	@Test
	@Order(1)
	void testSaveStaff() {
		Staff staff=new Staff();
		staff.setName("abc");
		staff.setPhoneno(456123);
		staffRepository.save(staff);
		assertNotNull(staffRepository.findById(1).get());
	}

	@Test
	@Order(2)
	void testUpdateStaff() {
		Staff staff=staffRepository.findById(1).get();
		staff.setName("xyz");
		staffRepository.save(staff);
	}

	@Test
	@Order(3)
	void testGetStaffById() {
		Staff staff=staffRepository.findById(1).get();
		assertEquals("xyz", staff.getName());
	}

	@Test
	@Order(4)
	void testDeleteStaffById() {
		staffRepository.deleteById(1);
	}

}
