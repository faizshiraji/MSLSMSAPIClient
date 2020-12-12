package com.mslapiagent.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@JsonDeserialize
public class MSLApiAgent{

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tranId;
	private String clientTranId;
	private String msisdn;
	private String msgbody;
	

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
