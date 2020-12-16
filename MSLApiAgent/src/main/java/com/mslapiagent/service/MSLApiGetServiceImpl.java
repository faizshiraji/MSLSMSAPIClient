package com.mslapiagent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.mslapiagent.entity.MSLApiAgent;


public class MSLApiGetServiceImpl implements MSLApiGetService {

	String url = "http://localhost:8080/MSLSystem_3/api/v1/messages/";

	@Autowired
	private MSLApiAgentRepo mslApiAgentRepo;
	
	@Override
	@Transactional
	public MSLApiAgent findMslApiAgentById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		MSLApiAgent apiAgent = restTemplate.getForObject(url + id, MSLApiAgent.class);
			
		return apiAgent;
	}

	@Override
	@Transactional
	public MSLApiAgent findMslApiAgentByMsisdn(Long msisdn) {
		
		return null;
	}

	@Override
	@Transactional
	public MSLApiAgent findMslApiAgentByTranId(String tranId) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
