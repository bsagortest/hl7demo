package com.example.demo.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.HL7008;

public interface HL7008Repository extends CrudRepository<HL7008, Long> {
	
	ArrayList<HL7008> findByInMsgNo(String msgNo);
	
}
