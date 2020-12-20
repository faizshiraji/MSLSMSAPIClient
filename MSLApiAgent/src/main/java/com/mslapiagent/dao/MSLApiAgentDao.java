package com.mslapiagent.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mslapiagent.entity.MSLApiAgent;

public interface MSLApiAgentDao extends CrudRepository<MSLApiAgent, Integer> {
	List<MSLApiAgent> findByTranId(String tranId);
	
}
