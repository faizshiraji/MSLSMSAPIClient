package com.mslapiagent;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.mslapiagent.entity.MSLApiAgent;

public class MSLServices {

	private static String baseURL = "http://localhost:8080/MSLSystem_3/api/v1/messages";

	

	public ResponseEntity<MSLApiAgent> printResponse(MSLApiAgent mslApiAgent) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		headers.set("X-Request-Source", "Desktop");

		HttpEntity request = new HttpEntity(headers);

		ResponseEntity<MSLApiAgent> exchange = restTemplate.exchange(baseURL, HttpMethod.GET, request, MSLApiAgent.class);
		return exchange;
	}

}
