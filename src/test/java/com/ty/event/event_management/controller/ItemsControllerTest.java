package com.ty.event.event_management.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.Items;
import com.ty.event.event_management.repository.ItemsRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ItemsControllerTest {
	@Autowired
	ItemsRepository itemsRepository;

	@Test
	void testSaveItems() {
		Items items=new Items();
		items.setCost(50);
		items.setDescription("delicious");
		items.setName("dosa");
		items.setQuantity(5);
		itemsRepository.save(items);
		assertNotNull(itemsRepository.findById(1).get());
	}

	@Test
	void testUpdateItems() {
		Items items=itemsRepository.findById(1).get();
		items.setName("idli");
		itemsRepository.save(items);
	}

	@Test
	void testFetchItemsById() {
		Items items=itemsRepository.findById(1).get();
		assertEquals("5", items.getQuantity());
	}

	@Test
	void testDeleteItemsById() {
		itemsRepository.deleteById(1);
	}

}
