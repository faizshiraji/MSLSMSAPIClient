package com.mslapiagent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mslapiagent.entity.MSLApiAgent;
import java.lang.Long;

@Repository
public interface MSLApiAgentRepo extends CrudRepository<MSLApiAgent, Integer> {
	boolean findByTranId(String tranId);
	Optional<MSLApiAgent> findById(Integer id);
	List<MSLApiAgent> findByMsisdn(Long msisdn);
	List<MSLApiAgent> findByMsisdn(String string);
}
