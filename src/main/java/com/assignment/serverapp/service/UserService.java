package com.assignment.serverapp.service;

import com.assignment.serverapp.util.CustomUserDetails;
import com.assignment.serverapp.model.User;
import com.assignment.serverapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public CustomUserDetails  loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        log.debug("User" + user.toString());

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(CustomUserDetails::new).get();
    }
}
