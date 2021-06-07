package com.assignment.serverapp.controller;

import com.assignment.serverapp.dto.QuestionDto;
import com.assignment.serverapp.dto.QuestionSolutionDto;
import com.assignment.serverapp.exception.RequestParameterException;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.service.QuestionService;
import com.assignment.serverapp.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;

    /***
     * store question to database
     * @param questionDto question type object
     * @return true if success else false
     */
    @PostMapping("/ask")
    public ResponseEntity<String> askQuestion(@RequestBody QuestionDto questionDto) throws RequestParameterException {
        return ResponseUtil.filterResponse(questionService.save(questionDto));
    }

    /***
     * get all the questions for given user Id
     * @param id user id
     * @return list all questions match user id
     */
    @GetMapping("/get/user/{id}")
    public List<Question> getQuestionsByUser(@PathVariable int id) {
        return questionService.getByUserId(id);
    }

    /***
     * get all questions for given product id
     * @param id product id
     * @return list of all questions matches product id
     */
    @GetMapping("/get/product/{id}")
    public List<Question> getQuestionByProduct(@PathVariable int id) {
        return questionService.getByProductId(id);
    }

    /***
     * mark answer as solved update the entity in database
     * @param questionSolutionDto object to be updated
     * @return true if success else false
     * @throws RequestParameterException when any parameter is missing
     */
    @PutMapping("/solution")
    public ResponseEntity<String> addSolution(@RequestBody QuestionSolutionDto questionSolutionDto) throws RequestParameterException {
        return ResponseUtil.filterResponse(questionService.markAnswer(questionSolutionDto));
    }

    @ExceptionHandler({RequestParameterException.class})
    public ResponseEntity<String> handleAuthenticationException(RequestParameterException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
    }
}
