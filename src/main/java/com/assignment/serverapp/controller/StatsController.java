package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.StatsDto;
import com.assignment.serverapp.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/stats")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/get")
    public StatsDto get(){
        return statsService.getStats();
    }
}
