package com.ty.event.event_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.event.event_management.dto.EventDetails;

public interface EventDetailsRepository extends JpaRepository<EventDetails, Integer>{

}
