package com.ty.event.event_management.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.Menu;
import com.ty.event.event_management.repository.MenuRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class MenuControllerTest {
	@Autowired
	MenuRepository menuRepository;

	@Test
	void testSaveMenu() {
		Menu menu=new Menu();
		menu.setName("veg");
		menuRepository.save(menu);
		assertNotNull(menuRepository.findById(1).get());
		
	}

	@Test
	void testUpdateMenu() {
		Menu menu=menuRepository.findById(1).get();
		menu.setName("non veg");
		menuRepository.save(menu);
		
	}

	@Test
	void testFetchMenuById() {
		Menu menu=menuRepository.findById(1).get();
		assertEquals("non veg", menu.getName());
	}

	@Test
	void testDeleteMenuById() {
		menuRepository.deleteById(1);
	}

}
