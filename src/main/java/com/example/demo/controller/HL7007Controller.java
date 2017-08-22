package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.HL7007;
import com.example.demo.repo.HL7007Repository;

@Controller
public class HL7007Controller {
	
	private static final Logger log = LoggerFactory.getLogger(HL7007Controller.class);

	@Autowired
	private HL7007Repository repo;
	
	@RequestMapping("/hl7007Data")
	@ResponseBody
	public HashMap<String, Object> selectAll(){
		HashMap<String, Object> getAll = new HashMap<String, Object>();
		
		List<HL7007> hl7007List = (List<HL7007>) repo.findAll();
		getAll.put("data", hl7007List);
		
		return getAll;
	}
	
	@RequestMapping("/hl7007")
	public String hl7007(Model model){
		List<HL7007> hl7007List = (List<HL7007>) repo.findAll();
		
		model.addAttribute("hl7007List",hl7007List);
		
		return "index";
	}
	
}
