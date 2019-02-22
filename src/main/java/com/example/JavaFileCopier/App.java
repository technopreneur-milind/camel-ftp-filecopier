package com.example.JavaFileCopier;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			 public void configure() {
			 from("ftp://localhost:21"
			 + "?username=admin&password=admin")
			 .process(new Processor() {
				 public void process(Exchange exchange) throws Exception {
					 System.out.println("We just downloaded: "
					 + exchange.getIn().getHeader("CamelFileName"));
					 }
					});
			 }
			 });
			 context.start();
			 Thread.sleep(10000);
			// context.stop();
	}

}
