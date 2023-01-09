package com.ty.event.event_management.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.ItemsDao;
import com.ty.event.event_management.dto.Items;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToDelete;
import com.ty.event.event_management.exception.NoSuchIdFoundToUpdate;
import com.ty.event.event_management.util.ResponseStructure;



@Service
public class ItemsService {

	@Autowired
	private ItemsDao dao;
	public static final Logger logger = Logger.getLogger(ItemsService.class);

	public ResponseEntity<ResponseStructure<Items>> saveItems(Items items) {
		ResponseEntity<ResponseStructure<Items>> responseEntity;
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved");
		responseStructure.setData(dao.saveItems(items));
		logger.debug("Data Saved");
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Items>> updateItems(Items items, int id) {
		ResponseEntity<ResponseStructure<Items>> responseEntity;
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		Optional<Items> items2 = dao.getItemsById(id);
		if (items2.isPresent()) {
			items.setId(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(dao.updateItems(items));
			logger.info("Data Updated");
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchIdFoundToUpdate();
		}

	}

	public ResponseEntity<ResponseStructure<Items>> findItemsById(int id) {
		ResponseEntity<ResponseStructure<Items>> responseEntity;
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		Optional<Items> items2 = dao.getItemsById(id);
		if (items2.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Found");
			responseStructure.setData(items2.get());
		} else {
			logger.fatal("Data Not Found");
			throw new NoSuchIdFoundException();
		}
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Items>> deleteItemsById(int id) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<Items>();
		ResponseEntity<ResponseStructure<Items>> responseEntity = new ResponseEntity<ResponseStructure<Items>>(
				responseStructure, HttpStatus.OK);
		Optional<Items> optional = dao.getItemsById(id);
		if (optional.isPresent()) {
			dao.deleteItemsById(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(optional.get());
			logger.warn("Data Deleted");
			return responseEntity;
		} else {
			throw new NoSuchIdFoundToDelete("No Such Id Found To Delete");
		}
	}

}
