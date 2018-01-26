package org.open.cloud.idiom.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
@RestController
@EnableConfigurationProperties
public class IdiomUiApplication {

  @Autowired
  private LoadBalancerClient lb;


  @Autowired
  private Idioms idioms;

  @Autowired
  private IdiomService idiomService;
  
  @Bean
  @LoadBalanced
  RestTemplate restTemplate() {
      return new RestTemplate();
  }
  
  @RequestMapping(value = "/add")
  public String addition(){
      return idiomService.addition();
  }

  @RequestMapping("/choose")
  public ServiceInstance choose() {
    return lb.choose("Idioms");

  }

  @RequestMapping(value = "/", produces = "text/html")
  public String home() {
//    return idioms.idiom();
//    return idiomService.idiom();
    return idiomUiPropeties().getPrefix() + idiomService.idiom();
  }

  @FeignClient("idioms")
  public interface Idioms {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String idiom();
  }
  

  @Bean
  public IdiomUiProperties idiomUiPropeties() {
    return new IdiomUiProperties();

  }
  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(IdiomUiApplication.class, args);
    System.out.println(context.getEnvironment().getProperty("info.name"));

}
}