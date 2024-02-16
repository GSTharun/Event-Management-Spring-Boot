package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Menu;
import com.ty.event.event_management.repository.MenuRepository;



@Repository
public class MenuDao {

	@Autowired
	MenuRepository repository;

	public Menu saveMenu(Menu menu) {
		return repository.save(menu);
	}

	public Menu updateMenu(Menu menu) {
		return repository.save(menu);
	}

	public Optional<Menu> getMenuById(int id) {
		return repository.findById(id);
	}

	public void deleteMenuById(Menu menu) {
		repository.delete(menu);

	}

}
