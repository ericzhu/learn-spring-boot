package com.booster.ecom.service.spring;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.booster.ecom.model.entity.Role;
import com.booster.ecom.model.entity.User;
import com.booster.ecom.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void assignRole(Role role, Long userId) {
        // TODO Auto-generated method stub
        
    }

}
