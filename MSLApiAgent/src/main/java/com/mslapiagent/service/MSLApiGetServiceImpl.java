package com.mslapiagent.service;

import javax.transaction.Transactional;

import org.springframework.web.client.RestTemplate;

import com.mslapiagent.entity.MSLApiAgent;

public class MSLApiGetServiceImpl implements MSLApiGetService {

	String url = "http://localhost:8080/MSLSystem_3/api/v1/messages/";
	
	@Override
	@Transactional
	public MSLApiAgent findMslApiAgent(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		MSLApiAgent apiAgent = restTemplate.getForObject(url + id, MSLApiAgent.class);
			
		return apiAgent;
	}

}
