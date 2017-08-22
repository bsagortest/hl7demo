package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HL7007 {

	@Column(name = "T_CONN_OPEN_DATE")
	private String connOpenDate;

	@Id
	@Column(name = "T_HL7_MSG_NO")
	private String messageNo;

	@Column(name = "T_PORT_ADDRESS")
	private String portAddress;

	@Column(name = "T_CLIENT_CODE")
	private String clientCode;

	public HL7007(String connOpenDate, String messageNo, String portAddress, String clientCode) {
		super();
		this.connOpenDate = connOpenDate;
		this.messageNo = messageNo;
		this.portAddress = portAddress;
		this.clientCode = clientCode;
	}

	public String getConnOpenDate() {
		return connOpenDate;
	}

	public void setConnOpenDate(String connOpenDate) {
		this.connOpenDate = connOpenDate;
	}

	public String getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(String messageNo) {
		this.messageNo = messageNo;
	}

	public String getPortAddress() {
		return portAddress;
	}

	public void setPortAddress(String portAddress) {
		this.portAddress = portAddress;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public HL7007() {

	}

}
