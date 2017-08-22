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

import com.example.demo.entity.OutBoundMessage;

@Controller
public class OutBoundMessageController {
	
private static final Logger log = LoggerFactory.getLogger(OutBoundMessageController.class);

	@Autowired
	DataSource datasource;
	
	@RequestMapping("/outMsgs")
	@ResponseBody
	public HashMap<String, Object> selectAll() throws SQLException{
		HashMap<String, Object> getAll = new HashMap<String, Object>();
		
		List<OutBoundMessage> obmList = new ArrayList<OutBoundMessage>();
		
		String sqlObm = "select hl7003.t_order_date, hl7003.t_order_no, hl7003.t_hl7_msg_no, hl7003.t_hl7_msg, "
							+ "hl7003.t_client_code, "
							+ "hl7008.t_receiving_date, hl7008.t_receiving_time, hl7008.t_in_msg_no, hl7008.t_ack_msg, "
							+ "hl7008.t_out_msg_no, hl7008.t_transmission_type, "
							+ "hl7008.t_vendor_id, hl7008.t_client_code "
						+ "from hl7003, hl7008 " 
						+"where hl7003.t_hl7_msg_no = hl7008.t_out_msg_no";

		Connection connection = datasource.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sqlObm);
			log.info("sqlObm:: {}", sqlObm);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet != null) {
				while (resultSet.next()) {
					OutBoundMessage entity = new OutBoundMessage();
					entity.setOrderDate(resultSet.getString("T_ORDER_DATE"));
					entity.setOrderNo(resultSet.getString("T_ORDER_NO"));
					entity.setMessageNo(resultSet.getString("T_OUT_MSG_NO"));
					entity.setMessageData(resultSet.getString("T_HL7_MSG"));
					entity.setClientCode(resultSet.getString("T_CLIENT_CODE"));
					entity.setReceivingDate(resultSet.getString("T_RECEIVING_DATE"));
					entity.setReceivingTime(resultSet.getString("T_RECEIVING_TIME"));
					entity.setInMsgNo(resultSet.getString("T_IN_MSG_NO"));
					entity.setAckMsg(resultSet.getString("T_ACK_MSG"));
					entity.setTransmissionType(resultSet.getString("T_TRANSMISSION_TYPE"));
					entity.setVendorId(resultSet.getString("T_VENDOR_ID"));
					
					obmList.add(entity);
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
		
		getAll.put("data", obmList);
		
		return getAll;
	}
}
