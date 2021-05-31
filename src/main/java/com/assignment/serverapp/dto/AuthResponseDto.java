package com.assignment.serverapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDto {
    private final String userName;
    private final int userId;
    private final String jwt;
}

