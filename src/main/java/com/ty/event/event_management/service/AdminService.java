package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.AdminDao;
import com.ty.event.event_management.dto.Admin;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseEntity<ResponseStructure<Admin>> responseEntity;
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data saved");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);

	}

	ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int id) {
		ResponseEntity<ResponseStructure<Admin>> responseEntity;
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Optional<Admin> optional = adminDao.getAdminById(id);
		if (optional.isPresent()) {
			optional.get();

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(adminDao.saveAdmin(admin));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		}
		throw null;

	}

	ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		ResponseEntity<ResponseStructure<Admin>> responseEntity;
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Optional<Admin> optional = adminDao.getAdminById(id);
		if (optional.isPresent()) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data found");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		}
		throw null;
	}

	ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id) {
		ResponseEntity<ResponseStructure<Admin>> responseEntity;
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		Optional<Admin> optional = adminDao.getAdminById(id);
		if (optional.isPresent()) {
            adminDao.deleteAdmin(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);
		}
		throw null;
	}

}
