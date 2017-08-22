package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HL7004 {

	@Column(name = "T_RECEIVED_DATE")
	private String receivedDate;

	@Column(name = "T_RECEIVED_TIME")
	private String receivedTime;

	@Id
	@Column(name = "T_HL7_MSG_NO")
	private String messageNo;

	@Column(name = "T_MSG_DATA")
	private String messageData;

	@Column(name = "T_MSG_DATA1")
	private String messageDataMore;

	@Column(name = "T_MSG_TYPE")
	private String messageType;

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(String receivedTime) {
		this.receivedTime = receivedTime;
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

	public String getMessageDataMore() {
		return messageDataMore;
	}

	public void setMessageDataMore(String messageDataMore) {
		this.messageDataMore = messageDataMore;
	}

	public HL7004(String receivedDate, String receivedTime, String messageNo, String messageData,
			String messageDataMore, String messageType) {
		super();
		this.receivedDate = receivedDate;
		this.receivedTime = receivedTime;
		this.messageNo = messageNo;
		this.messageData = messageData;
		this.messageDataMore = messageDataMore;
		this.messageType = messageType;
	}

	public HL7004() {

	}

}
