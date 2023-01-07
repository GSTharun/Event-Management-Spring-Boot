package com.ty.event.event_management.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.Admin;
import com.ty.event.event_management.repository.AdminRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AdminControllerTest {
	@Autowired
	AdminRepository adminRepository;

	@Test
	@Order(1)
	void testSaveAdmin() {
		Admin admin=new Admin();
		admin.setName("Manu");
		admin.setPhoneno(12589);
		admin.setEmail("m@123");
		admin.setPassword("m123");
		adminRepository.save(admin);
		assertNotNull(adminRepository.findById(1).get());
	}

	@Test
	@Order(2)
	void testUpdateAdmin() {
		Admin admin=adminRepository.findById(1).get();
		admin.setPassword("m@789");
		adminRepository.save(admin);
			}

	@Test
	@Order(3)
	void testGetAdminById() {
		Admin admin=adminRepository.findById(1).get();
		assertNotEquals("manu", admin.getName());
	}

	@Test
	@Order(4)
	void testDeleteAdminById() {
		adminRepository.deleteById(1);
	}

}
