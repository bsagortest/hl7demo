package com.example.demo.entity;

public class InBoundMessage {

	private String receivedDate;
	private String receivedTime;
	private String messageNo;
	private String messageData;
	private String messageType;
	private String sendingDate;
	private String sendingTime;
	private String ackMsg;
	private String outMsgNo;
	private String transmissionType;
	private String vendorId;

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

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getSendingDate() {
		return sendingDate;
	}

	public void setSendingDate(String sendingDate) {
		this.sendingDate = sendingDate;
	}

	public String getSendingTime() {
		return sendingTime;
	}

	public void setSendingTime(String sendingTime) {
		this.sendingTime = sendingTime;
	}

	public String getAckMsg() {
		return ackMsg;
	}

	public void setAckMsg(String ackMsg) {
		this.ackMsg = ackMsg;
	}

	public String getOutMsgNo() {
		return outMsgNo;
	}

	public void setOutMsgNo(String outMsgNo) {
		this.outMsgNo = outMsgNo;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

}
