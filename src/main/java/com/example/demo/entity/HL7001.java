package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HL7001 {

	@Column(name = "T_ORDER_DATE")
	private String orderDate;

	@Column(name = "T_ORDER_NO")
	private String orderNo;

	@Id
	@Column(name = "T_HL7_MSG_NO")
	private String messageNo;

	@Column(name = "T_HL7_MSG")
	private String messageData;

	@Column(name = "T_CLIENT_CODE")
	private String clientCode;

	public HL7001(String orderDate, String orderNo, String messageNo, String messageData, String clientCode) {
		super();
		this.orderDate = orderDate;
		this.orderNo = orderNo;
		this.messageNo = messageNo;
		this.messageData = messageData;
		this.clientCode = clientCode;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(String messageNo) {
		this.messageNo = messageNo;
	}

	public String getMessageData() {
		return messageData;
	}

	public void setMessageData(String messageData) {
		this.messageData = messageData;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public HL7001() {

	}

}
