package com.ty.event.event_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.event.event_management.dto.Items;


public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
