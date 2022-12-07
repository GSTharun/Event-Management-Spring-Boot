package com.ty.event.event_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.event.event_management.dto.Staff;

public interface StaffRepository  extends JpaRepository<Staff, Integer> {

}
