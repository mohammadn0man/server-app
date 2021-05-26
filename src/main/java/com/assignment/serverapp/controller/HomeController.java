package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.UserDto;
import com.assignment.serverapp.model.AuthRequest;
import com.assignment.serverapp.model.AuthResponse;
import com.assignment.serverapp.model.User;
import com.assignment.serverapp.repository.UserRepository;
import com.assignment.serverapp.service.UserService;
import com.assignment.serverapp.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtTokenUtil;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @PostMapping("/adduser")
    public User createUser(@RequestBody UserDto userDto) {
        var userModel = User.builder()
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .active(userDto.isActive())
                .roles(userDto.getRoles())
                .build();
        return repository.save(userModel);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
//            return new ResponseEntity<>("Hello World!", HttpStatus.BAD_REQUEST );
        }


        final var userDetails = userService
                .loadUserByUsername(authRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));
    }


    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}

