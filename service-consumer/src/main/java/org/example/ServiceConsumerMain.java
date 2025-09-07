package org.example;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@EnableDiscoveryClient
@EnableDubbo
@SpringBootApplication
@RestController
public class ServiceConsumerMain {

  @Bean
  @LoadBalanced
  public RestClient.Builder loadBalancedRestClientBuilder() {
    return RestClient.builder();
  }

  @Primary
  @Bean
  public RestClient.Builder restClientBuilder() {
    return RestClient.builder();
  }

  @GetMapping("/")
  public String hello() {
    return "hello consumer";
  }

  public static void main(String[] args) {
    SpringApplication.run(ServiceConsumerMain.class, args);
  }
}
