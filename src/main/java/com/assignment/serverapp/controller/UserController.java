package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.AuthRequestDto;
import com.assignment.serverapp.dto.AuthResponseDto;
import com.assignment.serverapp.dto.UserDto;
import com.assignment.serverapp.model.User;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @PostMapping("/signup")
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        var userModel = MapperUtil.getModelMapper().map(userDto, User.class);
        userModel.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        // TODO: 28-05-2021 add if user exist logic

        try {
            userRepository.save(userModel);
        } catch (Exception e) {
            log.error("signup exception : " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("something went wrong");
        }
        return ResponseEntity.status(HttpStatus.OK).body("USER_CREATED");
    }

    @PostMapping("/authenticate")
    public ResponseEntity createAuthenticationToken(@RequestBody AuthRequestDto authRequestDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword())
            );
        } catch (BadCredentialsException e) {
            log.error("Login with bad Credentials " + e);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("BAD_CREDENTIAL");
        }

        final var userDetails = userService
                .loadUserByUsername(authRequestDto.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponseDto(jwt));
    }


}
