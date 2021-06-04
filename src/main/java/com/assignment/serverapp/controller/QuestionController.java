package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.QuestionDto;
import com.assignment.serverapp.exception.RequestParameterException;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.service.QuestionService;
import com.assignment.serverapp.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody QuestionDto questionDto) throws RequestParameterException {
        return ResponseUtil.filterResponse(questionService.save(questionDto));
    }

    @GetMapping("/get/user/{id}")
    public List<Question> getQuestionsByUser(@PathVariable int id) {
        return questionService.getByUserId(id);
    }

    @GetMapping("/get/product/{id}")
    public List<Question> getQuestionByProduct(@PathVariable int id) {
        return questionService.getByProductId(id);
    }
}
