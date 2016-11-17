package com.booster.ecom.service.spring;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booster.ecom.model.entity.Role;
import com.booster.ecom.model.entity.User;
import com.booster.ecom.repository.db.UserRepository;
import com.booster.ecom.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void assignRole(Role role, Long userId) {

    }
}
