package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.MenuDao;
import com.ty.event.event_management.dto.Menu;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToDelete;
import com.ty.event.event_management.exception.NoSuchIdFoundToUpdate;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseEntity<ResponseStructure<Menu>> responseEntity;
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu, int id) {
		ResponseEntity<ResponseStructure<Menu>> responseEntity;
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		Optional<Menu> menu2 = dao.getMenuById(id);
		if (menu2 != null) {
			menu.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateMenu(menu));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchIdFoundToUpdate();
		}

	}

	public ResponseEntity<ResponseStructure<Menu>> findMenuById(int id) {
		ResponseEntity<ResponseStructure<Menu>> responseEntity;
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		Optional<Menu> menu2 = dao.getMenuById(id);
		if (menu2.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(menu2.get());
		} else {

			throw new NoSuchIdFoundException();

		}
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenuById(int id) {
		ResponseStructure<Menu> responseStructure = new ResponseStructure<Menu>();
		ResponseEntity<ResponseStructure<Menu>> responseEntity = new ResponseEntity<ResponseStructure<Menu>>(
				responseStructure, HttpStatus.OK);
		Optional<Menu> optional = dao.getMenuById(id);
		if (optional.isPresent()) {
			dao.deleteMenuById(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(optional.get());
			return responseEntity;
		} else {
			throw new NoSuchIdFoundToDelete("No Such Id Found To Delete");
		}
	}

}
