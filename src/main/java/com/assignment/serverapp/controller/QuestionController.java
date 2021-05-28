package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.QuestionDto;
import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.User;
import com.assignment.serverapp.repository.QuestionRepository;
import com.assignment.serverapp.repository.UserRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("question_by_user/{id}")
    public List<Question> getQuestionsByUser(@PathVariable int id) {
        return questionRepository.findByUser(User.builder().userId(id).build());
    }

    @GetMapping("question_by_username/{name}")
    public List<Question> getQuestionsByUser(@PathVariable String name) {
        Optional<User> user = userRepository.findByUserName(name);
        if (user.isPresent()){
            return getQuestionsByUser(user.get().getUserId());
        }
        return new ArrayList<>();
    }

    @GetMapping("question_by_product/{id}")
    public List<Question> getQuestionByProduct(@PathVariable int id){
        return questionRepository.findByProduct(Product.builder().productId(id).build());
    }

}
