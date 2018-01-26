package org.open.cloud.idiom;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
public class ExamApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ExamApplication.class).web(true).run(args);
	}
}