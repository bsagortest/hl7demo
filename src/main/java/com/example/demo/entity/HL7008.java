package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HL7008 {

	@Column(name = "T_SENDING_DATE")
	private String sendingDate;

	@Column(name = "T_SENDING_TIME")
	private String sendingTime;

	@Id
	@Column(name = "T_IN_MSG_NO")
	private String inMsgNo;

	@Column(name = "T_ACK_MSG")
	private String ackMsg;

	@Column(name = "T_OUT_MSG_NO")
	private String outMsgNo;

	@Column(name = "T_RECEIVING_DATE")
	private String receivingDate;

	@Column(name = "T_RECEIVING_TIME")
	private String receivingTime;

	@Column(name = "T_TRANSMISSION_TYPE")
	private String transmissionType;

	@Column(name = "T_VENDOR_ID")
	private String vendorId;

	@Column(name = "T_CLIENT_CODE")
	private String clientCode;

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

	public String getOutMsgNo() {
		return outMsgNo;
	}

	public void setOutMsgNo(String outMsgNo) {
		this.outMsgNo = outMsgNo;
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

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public HL7008() {

	}

	public HL7008(String sendingDate, String sendingTime, String inMsgNo, String ackMsg, String outMsgNo,
			String receivingDate, String receivingTime, String transmissionType, String vendorId, String clientCode) {
		super();
		this.sendingDate = sendingDate;
		this.sendingTime = sendingTime;
		this.inMsgNo = inMsgNo;
		this.ackMsg = ackMsg;
		this.outMsgNo = outMsgNo;
		this.receivingDate = receivingDate;
		this.receivingTime = receivingTime;
		this.transmissionType = transmissionType;
		this.vendorId = vendorId;
		this.clientCode = clientCode;
	}

}
