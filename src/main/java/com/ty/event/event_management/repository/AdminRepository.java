package com.ty.event.event_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.event.event_management.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
