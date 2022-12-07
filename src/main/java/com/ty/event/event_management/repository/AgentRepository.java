package com.ty.event.event_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.event.event_management.dto.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
