package com.assignment.serverapp.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    private ResponseUtil() {
    }
    public static ResponseEntity<String> filterResponse(boolean flag) {
        return flag ?
                ResponseEntity.status(HttpStatus.ACCEPTED).body("RESPONSE_SUBMITTED") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INVAID_PARAMETER");

    }
}
