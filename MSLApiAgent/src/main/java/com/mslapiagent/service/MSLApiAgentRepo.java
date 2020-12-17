package com.mslapiagent.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mslapiagent.entity.MSLApiAgent;

@Repository
public interface MSLApiAgentRepo extends CrudRepository<MSLApiAgent, Integer> {
	boolean findByTranId(String tranId);
}
