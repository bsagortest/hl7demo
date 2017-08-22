package com.example.demo.service;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class ClientServiceImpl extends RouteBuilder implements ClientService {
	private static final Logger log = LoggerFactory.getLogger(ClientService.class);
	
	@Autowired
//	@Produce(uri = "direct:mllp")
	ProducerTemplate template;
	

	String msg = "MSH|^~\\&|MEDISYS11| MEDISYS |RIS2010| KING SAUD MEDICAL COMPLEX |||ADT^O01|MSG014|P|2.3.1||||||8859/1 \r\n" + 
			"PID|||01583120^^^MEDISYS11||ALI^^KHLID^ALI||20120522|M||| RIYADH ^^^^0|||||||||||||||||01 \r\n" + 
			"PV1||E|L1266^0001^A||||1A1E|1A1E|1A1E||||||||1A1E \r\n" + 
			"ORC|NW|^|11931755^MEDISYS11 ||CM||1^once^^20150616110634^^3||20150616110634|^||___^|||||___^^  \r\n" + 
			"OBR||^|11931755^MEDISYS11 |00528^^|||||||||||^^^^|___^|||||||||||1^once^^20150616^^R/O|||| R/O";
	
	@Override
	public void exchange() throws Exception {
		
	}
	
	@Override
	public void configure() throws Exception {
		Object body = template.requestBody("mina2:tcp://100.43.0.11:7880?sync=true&codec=#hl7codec", msg);
		if (body != null) {
			log.info("SEND MESSGAE : {}", msg);
			if (body instanceof String) {
				String response = (String) body;
				log.info("ACK RECEIVE::" + response);
			}
		} else {
			log.info("BODY NULL");
		}
		
		/*from("direct:mllpServer")
		.doTry().to("mina2:tcp://100.43.0.11:7880?sync=true&codec=#hl7codec").log("port is opened {}")
		.doCatch(Exception.class).log("port is Closed {}").process(new Processor() {
			
			@Override
			public void process(Exchange arg0) throws Exception {
				arg0.getIn().setBody(null);
				
			}
		})
		.end();*/
		
		/*from("timer:foo")
        .to("log:bar");*/
	}

}
