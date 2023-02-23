package com.ty.event.event_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.event.event_management.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findUserByEmails(String emails);
}
