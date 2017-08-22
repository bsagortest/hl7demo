package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.HL7001;
import com.example.demo.repo.HL7001Repository;

@Controller
public class HL7001Controller {
	
	private static final Logger log = LoggerFactory.getLogger(HL7001Controller.class);

	@Autowired
	private HL7001Repository repo;
	
	@RequestMapping("/hl7001Data")
	@ResponseBody
	public HashMap<String, Object> selectAll(){
		HashMap<String, Object> getAll = new HashMap<String, Object>();
		
		List<HL7001> hl7001List = (List<HL7001>) repo.findAll();
		getAll.put("data", hl7001List);
		
		return getAll;
	}
	
}
