package com.assignment.serverapp.service;

import com.assignment.serverapp.dto.AuthRequestDto;
import com.assignment.serverapp.dto.AuthResponseDto;
import com.assignment.serverapp.dto.UserDto;
import com.assignment.serverapp.model.ExpireToken;
import com.assignment.serverapp.model.User;
import com.assignment.serverapp.repository.ExpireTokenRepository;
import com.assignment.serverapp.repository.UserRepository;
import com.assignment.serverapp.util.CustomUserDetails;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtTokenUtil;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    private ExpireTokenRepository expireTokenRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        log.debug("User" + user.toString());

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(CustomUserDetails::new).get();
    }

    public boolean checkUserExist(String username) {
        return userRepository.existsByUserName(username);
    }

    public AuthResponseDto createUser(UserDto userDto) {
        var userModel = MapperUtil.getModelMapper().map(userDto, User.class);
        userModel.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        try {
            userRepository.save(userModel);
        } catch (Exception e) {
            log.error("signup exception : " + e);
            return null;
        }

        final var userDetails = loadUserByUsername(userModel.getUserName());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return (new AuthResponseDto(
                userDetails.getUsername(),
                userDetails.getFullName(),
                userDetails.getUserId(),
                jwt));
    }

    public AuthResponseDto authenticateUser(AuthRequestDto authRequestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.error("Login with bad Credentials " + e);
            return null;
        }

        final var userDetails = loadUserByUsername(authRequestDto.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return (new AuthResponseDto(
                userDetails.getUsername(),
                userDetails.getFullName(),
                userDetails.getUserId(),
                jwt));
    }

    public boolean logout(String token) {
        try {
            expireTokenRepository.save(new ExpireToken(token.substring(7)));
        } catch (Exception e) {
            log.error("logout fail : " + e);
            return false;
        }
        return true;
    }
}
