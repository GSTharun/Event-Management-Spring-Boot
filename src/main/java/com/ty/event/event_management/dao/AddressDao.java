package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Address;
import com.ty.event.event_management.repository.AddressRepository;

@Repository
public class AddressDao {

	@Autowired
	private AddressRepository repository;

	public Address saveAddress(Address address) {
		return repository.save(address);
	}

	public Address updateAddress(Address address) {
		return repository.save(address);
	}

	public Optional<Address> getAddressById(int id) {
		return repository.findById(id);
	}

	public void deleteAddress(Address address) {
		repository.delete(address);
	}

}
