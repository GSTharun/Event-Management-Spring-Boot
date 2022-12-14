package com.ty.event.event_management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.event.event_management.dao.AddressDao;
import com.ty.event.event_management.dto.Address;
import com.ty.event.event_management.exception.NoSuchIdFoundException;
import com.ty.event.event_management.exception.UnableToUpdateException;
import com.ty.event.event_management.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	private AddressDao dao;
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data Saved");
		responseStructure.setData(dao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(Address address,int id) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		Optional<Address> optional = dao.getAddressById(id);
		if (optional.isPresent()) {
			address.setAddressid(id);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(dao.updateAddress(address));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);
		}
		throw new UnableToUpdateException("No Such Id Found To Update");
	}

	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		Optional<Address> optional = dao.getAddressById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Found");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);

		}
		throw new NoSuchIdFoundException("No Such Id Found");
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int id) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		Optional<Address> optional = dao.getAddressById(id);
		if (optional.isPresent()) {
			dao.deleteAddress(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Found");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure, HttpStatus.OK);

		}
		throw new NoSuchIdFoundException("No Such Id Found To Delete");
	}
}
