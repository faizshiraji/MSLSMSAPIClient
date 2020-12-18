package com.mslapiagent.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mslapiagent.dao.MSLApiAgentDao;
import com.mslapiagent.entity.MSLApiAgent;
import com.mslapiagent.service.MSLApiAgentRepo;

import net.bytebuddy.asm.Advice.This;

@Controller
public class ApiAgentController {

	@Autowired
	private MSLApiAgentRepo mslApiAgentRepo;
	
	@Autowired
	MSLApiAgentDao mslApiAgentDao;
	
	@Autowired
	private com.mslapiagent.service.SnowFlacks snowFlacks;
	
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
		String tranId = body.getTranId();
		Long clientTranId = body.getClientTranId();
		Long msisdn = body.getMsisdn();
		String msgbody = body.getMsgbody();

		model.addAttribute("exchanges", body);
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
		
		String forObject = restTemplate2.postForObject(url, request, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		List<MSLApiAgent> readValue = (List<MSLApiAgent>) objectMapper.readValue(forObject, MSLApiAgent.class);
		
		
		model.addAttribute("readValue", readValue);

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
		
		ArrayList<MSLApiAgent> arrayList = new ArrayList<>();

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
	
	@RequestMapping("/test08")
	public String attaComsianTest08(ModelMap modelMap, MSLApiAgent mslApiAgent) throws JsonMappingException, JsonProcessingException {

		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request
		String json = restTemplate2.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<MSLApiAgent> readValue = mapper.reader().forType(new TypeReference<List<MSLApiAgent>>() {}).readValue(json);
		
		ArrayList<MSLApiAgent> arrayList = new ArrayList<MSLApiAgent>();
		
		arrayList = (ArrayList<MSLApiAgent>) readValue;
		mslApiAgentRepo.saveAll(arrayList);
		
		modelMap.addAttribute("exchanges", readValue);
		// print json

		return "test02";
	}
	
	@RequestMapping("/test09")
	public String attaComsianTest09(ModelMap modelMap, MSLApiAgent mslApiAgent) throws JsonMappingException, JsonProcessingException {

		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request
		String json = restTemplate2.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<MSLApiAgent> readValue = mapper.reader().forType(new TypeReference<List<MSLApiAgent>>() {}).readValue(json);
		
		ArrayList<MSLApiAgent> arrayList = new ArrayList<MSLApiAgent>();
		
		arrayList = (ArrayList<MSLApiAgent>) readValue;
		mslApiAgentRepo.saveAll(arrayList);
		
		modelMap.addAttribute("exchanges", readValue);
		// print json

		return "test02";
	}
	
	@RequestMapping("/test10")
	public String attaComsianTest10(Model model, MSLApiAgent mslApiAgent) throws JsonMappingException, JsonProcessingException {
		// request url
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages/";

		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate();

		// make an HTTP GET request

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity request = new HttpEntity(headers);
		
		String json = restTemplate2.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<MSLApiAgent> readValue = mapper.reader().forType(new TypeReference<List<MSLApiAgent>>() {}).readValue(json);
		
		ArrayList<MSLApiAgent> arrayList = new ArrayList<MSLApiAgent>();
		arrayList = (ArrayList<MSLApiAgent>) readValue;
		
		Object[] array = arrayList.toArray();

		for (int i = 0; i < array.length; i++) {
			
			if (mslApiAgent.getId() != i) {
				ResponseEntity<MSLApiAgent> exchange = restTemplate2.exchange(url+i, HttpMethod.GET,request,MSLApiAgent.class);
				MSLApiAgent body = exchange.getBody();	
				mslApiAgentRepo.save(body);
				}

			}

		// print json

		return "test02";
		// Result: I can save all data to db. But here i need to use 2 types of rest call. And repeat data are saving to db. 
	}
	
	@RequestMapping("/test12")
	public String attaComsianTest12(Model model, MSLApiAgent mslApiAgent) {
		// request url

		Long msisdn  = 8801791631664L;
		System.out.println(msisdn);
		List<MSLApiAgent> findByMsisdn = mslApiAgentRepo.findByMsisdn(msisdn);
		List<MSLApiAgent> findByClientTranId = mslApiAgentRepo.findByClientTranId(null);
		
		List<MSLApiAgent> arrayList = new ArrayList<>();
		arrayList = (ArrayList<MSLApiAgent>)findByClientTranId;

		Object[] array = arrayList.toArray();
		String string = array.toString();

		if (array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				System.out.println(array[i]);			
			}			
		}

		
		return "test02";
	}
	
	@RequestMapping("/test13")
	public String attaComsianTest13() throws JsonMappingException, JsonProcessingException {
		// request url
		String urlPost = "http://localhost:8080/MSLSystem_3/api/v1/smsupdate";
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    JSONObject personJsonObject = new JSONObject();
	    personJsonObject.put("id", 1);
	    personJsonObject.put("tranId", 0);
	    personJsonObject.put("clientTranId", 123456);
	    personJsonObject.put("msisdn", "8801791631664");
	    personJsonObject.put("msgbody", "PW AB CW1234567");
	    
	    HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
	    restTemplate.postForObject(urlPost, request, String.class);
		
		return "test02";
	}
	
	@RequestMapping("/test14")
	public String bittaComsianTest14(MSLApiAgent mslApiAgent) {
		String url = "http://localhost:8080/MSLSystem_3/api/v1/messages/";
		String urlPost = "http://localhost:8080/MSLSystem_3/api/v1/smsupdate";
		// create an instance of RestTemplate
		RestTemplate restTemplate2 = new RestTemplate(); 

		// make an HTTP GET request

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		String mslAPIObjects = restTemplate2.getForObject(url, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			List<MSLApiAgent> readValue = mapper.reader().forType(new TypeReference<List<MSLApiAgent>>() {}).readValue(mslAPIObjects);
			
			ArrayList<MSLApiAgent> mslAPIArray = new ArrayList<MSLApiAgent>();
			
			mslAPIArray = (ArrayList<MSLApiAgent>) readValue;
			
			Object[] array = mslAPIArray.toArray();
			Long tranIDSearch = 1L;
			String t = String.valueOf(tranIDSearch);
			List<MSLApiAgent> findByTranId = mslApiAgentDao.findByTranId(t);
			
			Object[] array2 = findByTranId.toArray();
			int length = array2.length;
			System.out.println(length);
				for (int i = 0; i < array2.length; i++) {
					Object object = array[i];
					mslApiAgent = (MSLApiAgent) object;
//					String apiTranId = mslApiAgent.getTranId();
					System.out.println(mslApiAgent.toString());
				} 
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "test02";
		
	}
}
