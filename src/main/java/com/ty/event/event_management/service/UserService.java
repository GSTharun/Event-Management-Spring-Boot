package com.ty.event.event_management.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.controller.UserController;
import com.ty.event.event_management.dao.UserDao;
import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.UnableToUpdateException;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	private static final Logger logger=Logger.getLogger(UserController.class);


	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseEntity<ResponseStructure<User>> responseEntity;

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data saved");
		responseStructure.setData(userDao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user,int id) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(id);
		if (optional.isPresent()) {
			user.setUserid(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(userDao.saveUser(user));
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);

		}
		throw new UnableToUpdateException("No Such Id Found To Update");
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(id);
		if (optional.isPresent()) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data found");
			responseStructure.setData(optional.get());
			logger.info("get info");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);

		}
		throw new NoSuchIdFoundException("No Such Id Found");
	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(int id) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(id);
		if (optional.isPresent()) {
			userDao.deleteUser(optional.get());

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}

		throw new NoSuchIdFoundException("No Such Id Found To Delete");
	}

}
