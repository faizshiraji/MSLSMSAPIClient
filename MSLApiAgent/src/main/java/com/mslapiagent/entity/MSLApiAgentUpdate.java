package com.mslapiagent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class MSLApiAgentUpdate{

	private int id;
	private String tranId;
	private Long clientTranId;
	private Long msisdn;
	private String msgbody;
	
	
	public MSLApiAgentUpdate() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTranId() {
		return tranId;
	}
	public void setTranId(String tranId) {
		this.tranId = tranId;
	}
	public Long getClientTranId() {
		return clientTranId;
	}
	public void setClientTranId(Long clientTranId) {
		this.clientTranId = clientTranId;
	}
	public Long getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(Long integer) {
		this.msisdn = integer;
	}
	public String getMsgbody() {
		return msgbody;
	}
	public void setMsgbody(String msgbody) {
		this.msgbody = msgbody;
	}
	@Override
	public String toString() {
		return "MSLApiAgent [id=" + id + ", tranId=" + tranId + ", clientTranId=" + clientTranId + ", msisdn=" + msisdn
				+ ", msgbody=" + msgbody + "]";
	}
	
	
	
	
}
