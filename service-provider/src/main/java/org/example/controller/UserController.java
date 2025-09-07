package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.UserRepository;
import org.example.entity.UserEntity;
import org.example.model.User;
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
  @Autowired private UserRepository userRepository;

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
    UserEntity userEntity = userRepository.findById(id).orElse(null);
    User user = convertToModel(userEntity);
    log.info("get user by id: {}", user);
    if (null == user) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(user);
  }

  private User convertToModel(UserEntity userEntity) {
    if (null == userEntity) {
      return null;
    }
    User model = new User();
    model.setId(userEntity.getId());
    model.setName(userEntity.getName());
    model.setAge(userEntity.getAge());
    model.setBalance(userEntity.getBalance());
    return model;
  }
}
