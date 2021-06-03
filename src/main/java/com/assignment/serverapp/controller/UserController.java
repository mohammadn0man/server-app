package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.AuthRequestDto;
import com.assignment.serverapp.dto.AuthResponseDto;
import com.assignment.serverapp.dto.UserDto;
import com.assignment.serverapp.service.UserService;
import com.assignment.serverapp.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user_logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        return ResponseUtil.filterResponse(userService.logout(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        return userService.checkUserExist(userDto.getUserName()) ?
                ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("USER_ALREADY_EXISTS") :
                returnToken(userService.createUser(userDto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestDto authRequestDto) {
        return returnToken(userService.authenticateUser(authRequestDto));
    }

    public ResponseEntity<?> returnToken(AuthResponseDto authResponseDto) {
        return (authResponseDto == null) ?
                ResponseEntity.status(HttpStatus.FORBIDDEN).body("INVALID_CREDENTIAL") :
                ResponseEntity.ok(authResponseDto);
    }

}

