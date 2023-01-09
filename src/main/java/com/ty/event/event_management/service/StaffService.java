package com.ty.event.event_management.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.StaffDao;
import com.ty.event.event_management.dto.Staff;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.NoSuchIdFoundToDelete;
import com.ty.event.event_management.exception.NoSuchIdFoundToUpdate;
import com.ty.event.event_management.util.ResponseStructure;


@Service
public class StaffService {

	@Autowired
	private StaffDao staffdao;
	
	public static final Logger logger = Logger.getLogger(StaffService.class);

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		ResponseEntity<ResponseStructure<Staff>> responseEntity;

		ResponseStructure<Staff> responseStructure = new ResponseStructure<Staff>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data saved");
		responseStructure.setData(staffdao.saveStaff(staff));
		logger.debug("Data Saved");
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff, int id) {
		ResponseEntity<ResponseStructure<Staff>> responseEntity;
		ResponseStructure<Staff> responseStructure = new ResponseStructure<Staff>();
		Optional<Staff> optional = staffdao.getStaffById(id);
		if (optional.isPresent()) {
			staff.setStaffid(id);
			staffdao.updateStaff(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(staffdao.saveStaff(staff));
			logger.info("Data Updated");
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);

		} else {
			throw new NoSuchIdFoundToUpdate("No Such Id Found To Update");
		}
	}

	public ResponseEntity<ResponseStructure<Staff>> getStaffById(int id) {
		ResponseEntity<ResponseStructure<Staff>> responseEntity;
		ResponseStructure<Staff> responseStructure = new ResponseStructure<Staff>();
		Optional<Staff> optional = staffdao.getStaffById(id);
		if (optional.isPresent()) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data found");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);

		} else {
			logger.fatal("Data Not Found");
			throw new NoSuchIdFoundException("No Such Id Found");
		}
	}

	public ResponseEntity<ResponseStructure<Staff>> deleteStaffById(int id) {
		ResponseEntity<ResponseStructure<Staff>> responseEntity;
		ResponseStructure<Staff> responseStructure = new ResponseStructure<Staff>();
		Optional<Staff> optional = staffdao.getStaffById(id);
		if (optional.isPresent()) {
			staffdao.deleteStaff(optional.get());

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			logger.warn("Data Deleted");
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoSuchIdFoundToDelete("No Such Id Found To Delete");
		}
	}

}
