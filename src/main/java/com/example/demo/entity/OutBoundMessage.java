package com.example.demo.entity;

public class OutBoundMessage {

	private String orderDate;
	private String orderNo;
	private String messageNo;
	private String messageData;
	private String clientCode;
	private String inMsgNo;
	private String ackMsg;
	private String receivingDate;
	private String receivingTime;
	private String transmissionType;
	private String vendorId;

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

	public String getInMsgNo() {
		return inMsgNo;
	}

	public void setInMsgNo(String inMsgNo) {
		this.inMsgNo = inMsgNo;
	}

	public String getAckMsg() {
		return ackMsg;
	}

	public void setAckMsg(String ackMsg) {
		this.ackMsg = ackMsg;
	}

	public String getReceivingDate() {
		return receivingDate;
	}

	public void setReceivingDate(String receivingDate) {
		this.receivingDate = receivingDate;
	}

	public String getReceivingTime() {
		return receivingTime;
	}

	public void setReceivingTime(String receivingTime) {
		this.receivingTime = receivingTime;
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
