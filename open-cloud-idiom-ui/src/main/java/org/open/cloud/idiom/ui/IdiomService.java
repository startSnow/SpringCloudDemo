package org.open.cloud.idiom.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class IdiomService {
    @Autowired
    RestTemplate restTemplate;
  @Autowired
  private IdiomUiApplication.Idioms idioms;
  @HystrixCommand(fallbackMethod = "defaultIdiom")
  public String idiom() {
    return idioms.idiom();
  }

  public String defaultIdiom() {
    return "No pain, no gain";
}

@HystrixCommand(fallbackMethod = "addError")
public String addition() {
    return restTemplate.getForObject("http://idioms/add",String.class);
}

public String addError() {
    return "no gain";
}
}