package com.mslapiagent.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mslapiagent.entity.MSLApiAgent;

@Component("beforeCreateMSLApiAgentTransationValidator")
public class MSLApiAgentTransationValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MSLApiAgent.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		MSLApiAgent mslAgent = (MSLApiAgent) obj;
		if (checkInputString(mslAgent.getTranId())) {
			errors.rejectValue("TranId", "mslAgent.empty");
		}
	}

	private boolean checkInputString(String input) {
		// TODO Auto-generated method stub
		return (input == null || input.trim().length() == 0);
	}

}
