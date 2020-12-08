package com.mslapiagent.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mslapiagent.entity.MSLApiAgent;

@Controller
public class ApiAgentController {

	@RequestMapping("")
	public String Home() {

		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String Index() {

		return "index";
	}

	@RequestMapping("/test01")
	public String attaComsianTest01(ModelMap modelMap) {

		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request
		String json = restTemplate2.getForObject(url, String.class);
		String test = "It's my test.";
		modelMap.addAttribute("test", test);
		modelMap.addAttribute("json", json);
		// print json

		return "test01";
	}

	@RequestMapping("/test011")
	public String attaComsianTest011(ModelMap modelMap) {

		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request
		String json = restTemplate2.getForObject(url, String.class);
		String test = "It's my test.";
		modelMap.addAttribute("test", test);
		modelMap.addAttribute("json", json);
		// print json

		return "test01";
	}
	
	@RequestMapping("/test02")
	public String attaComsianTest02(Model model, MSLApiAgent mslApiAgent) {
		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity request = new HttpEntity(headers);
		
		ResponseEntity<MSLApiAgent> exchange = restTemplate2.exchange(url, HttpMethod.GET,request,MSLApiAgent.class);
		
		MSLApiAgent body = exchange.getBody();
		int id = body.getId();
		BigInteger tranId = body.getTranId();
		String clientTranId = body.getClientTranId();
		String msisdn = body.getMsisdn();
		String msgbody = body.getMsgbody();

		model.addAttribute("exchanges", body);
//		model.addAttribute("tranId", tranId);
//		model.addAttribute("clientTranId", clientTranId);
//		model.addAttribute("msisdn", msisdn);
//		model.addAttribute("msgbody", msgbody);
		// print json

		return "test02";
	}
	
	@RequestMapping("/test03")
	public String attaComsianTest03(Model model) throws JsonMappingException, JsonProcessingException {

		// request url

		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity request = new HttpEntity(headers);
		
//		ResponseEntity<MSLApiAgent> exchange = restTemplate2.exchange(url, HttpMethod.GET,request,MSLApiAgent.class);
		String forObject = restTemplate2.postForObject(url, request, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		List<MSLApiAgent> readValue = (List<MSLApiAgent>) objectMapper.readValue(forObject, MSLApiAgent.class);
		
		
//		
//		String test = "It's my test.";

//		model.addAttribute("apiAgents", apiAgents);
		
		
//		model.addAttribute("test", test);
		model.addAttribute("readValue", readValue);
		// print json

		return "test02";
	}
	
	
	@RequestMapping("/test04")
	public String attaComsianTest04(Model model, MSLApiAgent mslApiAgent) {
		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages/2";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity request = new HttpEntity(headers);
		
		ResponseEntity<MSLApiAgent> exchange = restTemplate2.exchange(url, HttpMethod.GET,request,MSLApiAgent.class);
		
//		MSLApiAgent body = exchange.getBody();
		ArrayList<MSLApiAgent> arrayList = new ArrayList<>();
		
		
//		model.addAttribute("id", id);

		// print json

		return "test02";
	}

	@RequestMapping("/test06")
	public String attaComsianTest06(ModelMap modelMap) {
		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages/";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity request = new HttpEntity(headers);
		
		ResponseEntity<MSLApiAgent> exchange = restTemplate2.exchange(url, HttpMethod.GET,request,MSLApiAgent.class);
		MSLApiAgent body = exchange.getBody();
		
		
		modelMap.addAttribute("exchanges", body);


		return "test02";
	}
	
	@RequestMapping("/test07")
	public String attaComsianTest07(ModelMap modelMap) throws JsonMappingException, JsonProcessingException {

		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request
		String json = restTemplate2.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<MSLApiAgent> readValue = mapper.reader().forType(new TypeReference<List<MSLApiAgent>>() {}).readValue(json);
		
		
		
		modelMap.addAttribute("exchanges", readValue);
		// print json

		return "test02";
	}
	
	
}
