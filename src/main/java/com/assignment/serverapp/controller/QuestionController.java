package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.QuestionDto;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return questionService.save(questionDto) ?
                ResponseEntity.status(HttpStatus.ACCEPTED).body("RECORD_ADDED") :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INVALID_PARAMETER");
    }

    @GetMapping("/get_all_question")
    public List<Question> getQuestion() {
        return questionService.getAll();
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
