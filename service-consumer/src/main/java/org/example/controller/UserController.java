package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@Slf4j
@RequestMapping("/v1/users")
@RestController
public class UserController {
  @Autowired @LoadBalanced private RestClient.Builder loadBalancedRestClientBuilder;

  @Autowired private RestClient.Builder restClientBuilder;

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    User user =
        loadBalancedRestClientBuilder
            .build()
            .get()
            .uri("http://service-provider/users/{id}", id)
            .retrieve()
            .body(User.class);
    log.info("get user by id: {}", user);
    return ResponseEntity.ok(user);
  }
}
