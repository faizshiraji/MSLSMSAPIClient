package com.mslapiagent.service;

import com.mslapiagent.entity.MSLApiAgent;

public interface MSLApiGetService {
	public MSLApiAgent findMslApiAgentById(Long id);
	public MSLApiAgent findMslApiAgentByMsisdn(Long msisdn);
	public MSLApiAgent findMslApiAgentByTranId(String tranId);
	public String findNewTranId(String apiTranId);
}
