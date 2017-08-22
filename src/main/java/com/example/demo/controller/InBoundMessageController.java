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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.InBoundMessage;

@Controller
public class InBoundMessageController {
	
private static final Logger log = LoggerFactory.getLogger(InBoundMessageController.class);

	@Autowired
	DataSource datasource;
	
	@RequestMapping("/inMsgs")
	@ResponseBody
	public HashMap<String, Object> selectAll() throws SQLException{
		HashMap<String, Object> getAll = new HashMap<String, Object>();
		
		List<InBoundMessage> ibmList = new ArrayList<InBoundMessage>();
		
		String sqlIbm = "select hl7004.t_hl7_msg_no, hl7004.t_received_date, hl7004.t_received_time, hl7004.t_msg_data, "
								+ "hl7004.t_msg_data1, hl7004.t_msg_type, " 
								+ "hl7008.t_sending_date, hl7008.t_sending_time, hl7008.t_in_msg_no, hl7008.t_ack_msg, "
								+ "hl7008.t_out_msg_no, "
								+ "hl7008.t_transmission_type, hl7008.t_vendor_id, hl7008.t_client_code " 
							+ "from hl7004, hl7008 "
							+ "where hl7004.t_hl7_msg_no = hl7008.t_in_msg_no";

		Connection connection = datasource.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlIbm);
			log.info("sqlIbm:: {}", sqlIbm);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					InBoundMessage entity = new InBoundMessage();
					entity.setMessageNo(resultSet.getString("T_IN_MSG_NO"));
					entity.setMessageData(resultSet.getString("T_MSG_DATA") + resultSet.getString("T_MSG_DATA1"));
					entity.setMessageType(resultSet.getString("T_MSG_TYPE"));
					entity.setReceivedDate(resultSet.getString("T_RECEIVED_DATE"));
					entity.setReceivedTime(resultSet.getString("T_RECEIVED_TIME"));
					entity.setAckMsg(resultSet.getString("T_ACK_MSG"));
					entity.setSendingDate(resultSet.getString("T_SENDING_DATE"));
					entity.setSendingTime(resultSet.getString("T_SENDING_TIME"));
					entity.setTransmissionType(resultSet.getString("T_TRANSMISSION_TYPE"));
					entity.setVendorId(resultSet.getString("T_VENDOR_ID"));
					entity.setOutMsgNo(resultSet.getString("T_OUT_MSG_NO"));
					
					ibmList.add(entity);
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
		
		getAll.put("data", ibmList);
		
		return getAll;
	}
}
