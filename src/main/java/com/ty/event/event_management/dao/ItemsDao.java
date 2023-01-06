package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Items;
import com.ty.event.event_management.repository.ItemsRepository;


@Repository
public class ItemsDao {

	@Autowired
	ItemsRepository repository;

	public Items saveItems(Items items) {
		return repository.save(items);
	}

	public Items updateItems(Items items) {
		return repository.save(items);
	}

	public Optional<Items> getItemsById(int id) {
		return repository.findById(id);
	}

	public void deleteItemsById(Items items) {
		repository.delete(items);

	}

}
