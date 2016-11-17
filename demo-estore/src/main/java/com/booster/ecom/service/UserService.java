package com.booster.ecom.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.booster.ecom.model.entity.Role;
import com.booster.ecom.model.entity.User;

public interface UserService extends UserDetailsService {

    public void addUser(User user);

    public void assignRole(Role role, Long userId);

}
