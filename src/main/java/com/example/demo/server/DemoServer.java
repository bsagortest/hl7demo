package com.example.demo.server;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import ca.uhn.hl7v2.HL7Exception;

@Component
public class DemoServer extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("mina2:tcp://0.0.0.0:4001?sync=true&codec=#hl7codec").process(new Processor() {
	        public void process(Exchange exchange) throws HL7Exception {
	        	String remoteAddress = exchange.getIn().getHeader("CamelMina2RemoteAddress", String.class);
	        	log.info("RemoteAddress:: {}", remoteAddress);
	        	
	            String body = exchange.getIn().getBody(String.class);
	            Map<String, Object>  props = exchange.getProperties();
	            
	            for(String key : props.keySet()){
	            	log.debug("Exchange Property >> Key: {}, Val: {}", key, props.get(key));
//	            	log.info("Exchange Property >> Key: {}, Val: {}", key, props.get(key));
	            }
	            
	            log.info("RECEIVE MESSAGE: {}", body);
	        }
	    });
	}
}
