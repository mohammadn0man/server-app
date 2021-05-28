package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.QuestionDto;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.repository.QuestionRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/ask_question")
    public ResponseEntity<String> askQuestion(@RequestBody QuestionDto questionDto) {
        var question = MapperUtil.getModelMapper().map(questionDto, Question.class);
        question.setCreationDate(new Date());
        try {
            questionRepository.save(question);
        } catch (Exception e) {
            log.error("error in adding request : " + e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Question not added " + e);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("RECORD_ADDED");
    }

    @GetMapping("/get_all_question")
    public List<Question> getQuestion() {
        return (List<Question>) questionRepository.findAll();
    }


}
