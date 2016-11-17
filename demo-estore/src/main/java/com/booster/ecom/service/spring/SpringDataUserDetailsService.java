package com.booster.ecom.service.spring;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.booster.ecom.model.entity.User;
import com.booster.ecom.repository.db.UserRepository;

@Component
public class SpringDataUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public SpringDataUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
            Stream.of(user.getRoles()).map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
    }

}
