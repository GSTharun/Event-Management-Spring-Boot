package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.repository.UserRepository;



@Repository
public class UserDao {

	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> getUserById(String id) {
		return repository.findById(id);
	}

	public void deleteUser(User user) {
		repository.delete(user);
	}
	public  User getUserByEmail(String email) {
		return repository.findUserByEmails(email);
		
	}

}
