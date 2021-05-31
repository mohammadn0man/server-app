package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.AuthRequestDto;
import com.assignment.serverapp.dto.AuthResponseDto;
import com.assignment.serverapp.dto.UserDto;
import com.assignment.serverapp.model.ExpireToken;
import com.assignment.serverapp.model.User;
import com.assignment.serverapp.repository.ExpireTokenRepository;
import com.assignment.serverapp.repository.UserRepository;
import com.assignment.serverapp.service.JwtService;
import com.assignment.serverapp.service.UserService;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtTokenUtil;

    @Autowired
    private ExpireTokenRepository expireTokenRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user_logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        expireTokenRepository.save(new ExpireToken(token.substring(7)));
        return ResponseEntity.status(HttpStatus.OK).body("LOGOUT_SUCCESSFUL");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        var userModel = MapperUtil.getModelMapper().map(userDto, User.class);
        userModel.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        if (userRepository.existsByUserName(userDto.getUserName())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("USER_ALREADY_EXISTS");
        }

        try {
            userRepository.save(userModel);
        } catch (Exception e) {
            log.error("signup exception : " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong");
        }

        final var userDetails = userService
                .loadUserByUsername(userModel.getUserName());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponseDto(userDetails.getUsername(), userDetails.getUserId(), jwt));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestDto authRequestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.error("Login with bad Credentials " + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("INVALID_CREDENTIAL");
        }

        final var userDetails = userService
                .loadUserByUsername(authRequestDto.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponseDto(userDetails.getUsername(), userDetails.getUserId(), jwt));
    }

}

