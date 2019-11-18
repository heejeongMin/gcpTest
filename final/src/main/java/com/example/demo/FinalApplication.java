package com.example.demo;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("com.example")
@SpringBootApplication
public class FinalApplication {
	
	
	@Bean
	public TomcatServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
	      @Override
	      protected void postProcessContext(Context context) {
	        SecurityConstraint securityConstraint = new SecurityConstraint();
	        securityConstraint.setUserConstraint("CONFIDENTIAL");
	        SecurityCollection collection = new SecurityCollection();
	        collection.addPattern("/*");
	        securityConstraint.addCollection(collection);
	        context.addConstraint(securityConstraint);
	      }
	    };
	   
	  tomcat.addAdditionalTomcatConnectors(redirectConnector());
	  return tomcat;
	}
	 
	private Connector redirectConnector() {
	  Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	  connector.setScheme("http");
	  connector.setSecure(false);
	  connector.setPort(8080);
//	  connector.setRedirectPort(8443);
	   
	  return connector;
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalApplication.class, args);
	}
	
	

}
