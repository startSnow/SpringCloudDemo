package org.open.eureka.oauth2.client;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@Configuration
@EnableOAuth2Sso
@RestController
@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
public class OpenOauth2ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenOauth2ClientApplication.class, args);
	}
	
	  @RequestMapping("/")
	  public String home(Principal user) {
	    return "Hello " + user.getName();
	}
}
