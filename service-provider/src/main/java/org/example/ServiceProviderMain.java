package org.example;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@EnableDubbo
@SpringBootApplication
@RestController
public class ServiceProviderMain {

  @GetMapping("/")
  public String hello() {
    return "hello provider";
  }

  public static void main(String[] args) {
    SpringApplication.run(ServiceProviderMain.class, args);
  }
}
