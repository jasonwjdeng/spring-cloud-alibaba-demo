package org.example.controller;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    User user = userRepository.findById(id).orElse(null);
    log.info("get user by id: {}", user);
    if (null == user) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(user);
  }
}
