package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HL7009 {

	@Id
	@Column(name = "T_CLIENT_CODE")
	private String clientCode;

	@Column(name = "T_LANG2_NAME")
	private String clientName;

	@Column(name = "T_CLIENT_IP")
	private String clientIp;

	@Column(name = "T_CLIENT_PORT")
	private String portAddress;

	@Column(name = "T_SENDER_NAME")
	private String senderName;

	public HL7009(String clientCode, String clientName, String clientIp, String portAddress, String senderName) {
		super();
		this.clientCode = clientCode;
		this.clientName = clientName;
		this.clientIp = clientIp;
		this.portAddress = portAddress;
		this.senderName = senderName;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getPortAddress() {
		return portAddress;
	}

	public void setPortAddress(String portAddress) {
		this.portAddress = portAddress;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public HL7009() {

	}

}
