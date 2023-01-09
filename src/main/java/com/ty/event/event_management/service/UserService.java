package com.ty.event.event_management.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.hibernate.event.internal.EntityCopyAllowedLoggedObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.UserDao;
import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToUpdate;
import com.ty.event.event_management.util.AESencription;
import com.ty.event.event_management.util.ResponseStructure;



@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public static final Logger logger = Logger.getLogger(UserService.class);

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseEntity<ResponseStructure<User>> responseEntity;

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data saved");
		responseStructure.setData(userDao.saveUser(user));
		logger.debug("data Saved");
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user, int id) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(id);
		if (optional.isPresent()) {
			user.setUserid(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(userDao.saveUser(user));
			logger.info("data updated");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoSuchIdFoundToUpdate("No Such Id Found To Update");
		}
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(id);
		if (optional.isPresent()) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data found");
			responseStructure.setData(optional.get());

		} else {

			logger.fatal("data not found");
			throw new NoSuchIdFoundException();
		}
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(int id) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(id);
		if (optional.isPresent()) {
			userDao.deleteUser(optional.get());

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			logger.warn("data deleted");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		} else {

			throw new NoSuchIdFoundException("No Such Id Found To Delete");
		}
	}
	public String validateUserByEmailAndPassword(String email,String password) {
		User user=userDao.getUserByEmail(email);
		AESencription dec=new AESencription();
		if(password.equals(user.getPassword())){
			return "Logged In Succesfully";
		}
		return "Invalid Pasword";
	}

}
