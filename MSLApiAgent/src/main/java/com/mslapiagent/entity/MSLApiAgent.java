package com.mslapiagent.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//@Entity
@JsonDeserialize
public class MSLApiAgent{

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private int id;
	private BigInteger tranId;
	private String clientTranId;
	private String msisdn;
	private String msgbody;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigInteger getTranId() {
		return tranId;
	}
	public void setTranId(BigInteger tranId) {
		this.tranId = tranId;
	}
	public String getClientTranId() {
		return clientTranId;
	}
	public void setClientTranId(String clientTranId) {
		this.clientTranId = clientTranId;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
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
