package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.QuestionDto;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.service.QuestionService;
import com.assignment.serverapp.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/ask_question")
    public ResponseEntity<String> askQuestion(@RequestBody QuestionDto questionDto) {
        return ResponseUtil.filterResponse(questionService.save(questionDto));
    }

    @GetMapping("question_by_user/{id}")
    public List<Question> getQuestionsByUser(@PathVariable int id) {
        return questionService.getByUserId(id);
    }

    @GetMapping("question_by_product/{id}")
    public List<Question> getQuestionByProduct(@PathVariable int id) {
        return questionService.getByProductId(id);
    }
}
