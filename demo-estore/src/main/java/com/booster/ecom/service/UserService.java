package com.booster.ecom.service;

import com.booster.ecom.model.entity.Role;
import com.booster.ecom.model.entity.User;

public interface UserService {

    public void addUser(User user);

    public void assignRole(Role role, Long userId);

}
