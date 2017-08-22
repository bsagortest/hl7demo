package com.example.demo.config;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.hl7.HL7MLLPCodec;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Mina2Configuration {

	@Bean
	public CamelContext contex() {
		CamelContext camelContext;
		SimpleRegistry reg = new SimpleRegistry();
		reg.put("hl7codec", new HL7MLLPCodec());
		camelContext = new DefaultCamelContext(reg);
		return camelContext;
	}
	
	@Bean
	public ProducerTemplate template() {
		ProducerTemplate template = contex().createProducerTemplate();
		return template;
	}
	
}
