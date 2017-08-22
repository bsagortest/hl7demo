package com.example.demo.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

//@Component
public class ClientRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
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
