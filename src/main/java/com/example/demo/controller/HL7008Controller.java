package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.HL7008;
import com.example.demo.repo.HL7008Repository;

@Controller
public class HL7008Controller {
	
	private static final Logger log = LoggerFactory.getLogger(HL7008Controller.class);
	
	@Autowired
	private HL7008Repository repoHL7008;
	
	@RequestMapping("/hl7008")
	public String hl7008(Model model){
		List<HL7008> hl7008List = (List<HL7008>) repoHL7008.findAll();
		
		model.addAttribute("hl7008List",hl7008List);
		
		return "hl7008";
	}
}
