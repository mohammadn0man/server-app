package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.AuthRequestDto;
import com.assignment.serverapp.dto.AuthResponseDto;
import com.assignment.serverapp.dto.UserDto;
import com.assignment.serverapp.exception.RequestParameterException;
import com.assignment.serverapp.exception.UserException;
import com.assignment.serverapp.service.UserService;
import com.assignment.serverapp.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) throws RequestParameterException {
        return ResponseUtil.filterResponse(userService.logout(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) throws UserException {
        if (userService.checkUserExist(userDto.getUserName())) {
            throw new UserException("Registration Fail : user already exist");
        }
        return returnToken(userService.createUser(userDto));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequestDto authRequestDto) throws UserException {
        return returnToken(userService.authenticateUser(authRequestDto));
    }

    public ResponseEntity<?> returnToken(AuthResponseDto authResponseDto) throws UserException {
        if (authResponseDto == null) {
            throw new UserException("You have entered invalid credentials");
        }
        return ResponseEntity.ok(authResponseDto);
    }

    @ExceptionHandler({UserException.class})
    public ResponseEntity<String> handleAuthenticationException(UserException e) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    }
}

