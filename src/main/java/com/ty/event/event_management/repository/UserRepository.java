package com.ty.event.event_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.event.event_management.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}