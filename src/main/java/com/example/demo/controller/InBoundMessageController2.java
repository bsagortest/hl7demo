package com.example.demo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.HL7004;
import com.example.demo.entity.HL7008;
import com.example.demo.entity.InBoundMessage;

//@Controller
public class InBoundMessageController2 {

	private static final Logger log = LoggerFactory.getLogger(InBoundMessageController2.class);

	@Autowired
	DataSource datasource;
	
	@RequestMapping(value = "/inMsgs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public HashMap<String, Object> selectAll(String username, String password) throws SQLException {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<InBoundMessage> ibmList = new ArrayList<InBoundMessage>();
		List<HL7004> hl7004List = getHL7004Data();
		List<HL7008> hl7008List = getHL7008Data();

		/*String sql = "select * from hl7008 "
				+ "where rownum < (select count(t_transmission_type) from hl7008 "
					+ "where rownum < 1000) and t_transmission_type = '1'";*/
		for(HL7004 m : hl7004List) {
			InBoundMessage ibm = new InBoundMessage();
			ibm.setMessageNo(m.getMessageNo());
			ibm.setMessageData(m.getMessageData());
			ibm.setMessageType(m.getMessageType());
			ibm.setReceivedDate(m.getReceivedDate());
			ibm.setReceivedTime(m.getReceivedTime());
			log.info("hl7008List.size:: {}", hl7008List.size());
			if(hl7008List.size() > 0) {
				for(int i = 0; i < hl7008List.size(); i++) {
					if(hl7008List.get(i).getInMsgNo().equals(m.getMessageNo())) {
						ibm.setAckMsg(hl7008List.get(i).getAckMsg());
						ibm.setSendingDate(hl7008List.get(i).getSendingDate());
						ibm.setSendingTime(hl7008List.get(i).getSendingTime());
						ibm.setTransmissionType(hl7008List.get(i).getTransmissionType());
						ibm.setVendorId(hl7008List.get(i).getVendorId());
					}
				}
			}
			
			ibmList.add(ibm);
		}
		

		if (ibmList != null) {
			plr.put("data", ibmList);
		} 

		return plr;
	}

	private List<HL7008> getHL7008Data() throws SQLException {
		List<HL7008> hl7008List = new ArrayList<HL7008>();
		
		String sqlHL7008 = "select * from hl7008";

		Connection connection = datasource.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlHL7008);
			log.info("sqlHL7008:: {}", sqlHL7008);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					HL7008 entity = new HL7008();
					entity.setInMsgNo(resultSet.getString("T_IN_MSG_NO"));
					entity.setAckMsg(resultSet.getString("T_ACK_MSG"));
					entity.setSendingDate(resultSet.getString("T_SENDING_DATE"));
					entity.setSendingTime(resultSet.getString("T_SENDING_TIME"));
					entity.setTransmissionType(resultSet.getString("T_TRANSMISSION_TYPE"));
					entity.setVendorId(resultSet.getString("T_VENDOR_ID"));
					
					hl7008List.add(entity);
				}
			} else {
				System.out.println("not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return hl7008List;
	}

	private List<HL7004> getHL7004Data() throws SQLException {
		List<HL7004> hl7004List = new ArrayList<HL7004>();
		
		String sqlHL7004 = "select * from hl7004 where ROWNUM < 100";

		Connection connection = datasource.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlHL7004);
			log.info("sqlHL7004:: {}", sqlHL7004);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					HL7004 entity = new HL7004();
					/*entity.setMessageNo(resultSet.getString("T_IN_MSG_NO"));
					entity.setAckMsg(resultSet.getString("T_ACK_MSG"));
					entity.setSendingDate(resultSet.getString("T_SENDING_DATE"));
					entity.setSendingTime(resultSet.getString("T_SENDING_TIME"));
					entity.setTransmissionType(resultSet.getString("T_TRANSMISSION_TYPE"));
					entity.setVendorId(resultSet.getString("T_VENDOR_ID"));*/
					
					entity.setMessageNo(resultSet.getString("T_HL7_MSG_NO"));
					entity.setMessageData(resultSet.getString("T_MSG_DATA") + resultSet.getString("T_MSG_DATA1"));
					entity.setMessageType(resultSet.getString("T_MSG_TYPE"));
					entity.setReceivedDate(resultSet.getString("T_RECEIVED_DATE"));
					entity.setReceivedTime(resultSet.getString("T_RECEIVED_TIME"));
					
					hl7004List.add(entity);
				}
			} else {
				System.out.println("not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return hl7004List;
	}
}
