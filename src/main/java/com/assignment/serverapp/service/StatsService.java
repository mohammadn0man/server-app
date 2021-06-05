package com.assignment.serverapp.service;

import com.assignment.serverapp.dto.StatsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final QuestionService questionService;
    private final ReplyService replyService;
    private final UserService userService;

    public StatsDto getStats(){
        return StatsDto.builder()
                .questionCount(questionService.getCount())
                .responseCount(replyService.getCount())
                .userCount(userService.getCount())
                .build();
    }
}
