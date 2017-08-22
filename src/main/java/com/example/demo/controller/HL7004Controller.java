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

import com.example.demo.entity.HL7004;
import com.example.demo.repo.HL7004Repository;

@Controller
public class HL7004Controller {
	
	private static final Logger log = LoggerFactory.getLogger(HL7004Controller.class);

	@Autowired
	private HL7004Repository repo;
	
	@RequestMapping("/adminPan")
	public String adminPan(){
		
		return "adminPan";
	}
	
	@RequestMapping("/")
	public String index(Model model){
		/*List<HL7004> hl7004List = (List<HL7004>) repo.findAll();
		List<HL7008> hl7008List = (List<HL7008>) repoHL7008.findByInMsgNo(hl7004List.get(0).getMessageNo());
		log.info("hl7008List.size {}",hl7008List.size());
		log.info("HL7008Data::{}",hl7008List.get(0).getInMsgNo() + " + " + hl7008List.get(0).getAckMsg());
		
		model.addAttribute("hl7004List",hl7004List);
		model.addAttribute("hl7008List",hl7008List);*/
		
		return "index";
	}
	
	@RequestMapping("/hl7004")
	public String hl7004(Model model){
		List<HL7004> hl7004List = (List<HL7004>) repo.findAll();
		
		model.addAttribute("hl7004List",hl7004List);
		
		return "hl7004";
	}
	
	/*@RequestMapping("/hl7001")
	public String hl7001(Model model){
		List<HL7004> hl7004List = (List<HL7004>) repo.findAll();
		model.addAttribute("hl7004List",hl7004List);
		
		return "hl7001";
	}*/
	
	@RequestMapping("/hl7004Data")
	@ResponseBody
	public HashMap<String, Object> selectAll(){
		HashMap<String, Object> getAll = new HashMap<String, Object>();
		
		List<HL7004> hl7004List = (List<HL7004>) repo.findAll();
		getAll.put("data", hl7004List);
		
		return getAll;
	}
	
}
