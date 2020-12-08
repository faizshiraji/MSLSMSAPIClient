package com.mslapiagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.mslapiagent.entity.MSLApiAgent;

@SpringBootApplication
public class MslApiAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MslApiAgentApplication.class, args);
		
	}
	
}
