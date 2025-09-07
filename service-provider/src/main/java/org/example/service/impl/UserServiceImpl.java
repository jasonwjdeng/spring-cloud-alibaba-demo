package org.example.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.UserEntity;
import org.example.model.User;
import org.example.service.UserService;
import org.example.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return convertToModel(userEntity);
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
