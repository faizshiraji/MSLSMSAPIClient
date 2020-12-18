package com.mslapiagent.dao;

import org.springframework.data.repository.CrudRepository;

import com.mslapiagent.entity.MSLApiAgent;

public interface MSLApiAgentDao extends CrudRepository<MSLApiAgent, Integer> {
	
}
