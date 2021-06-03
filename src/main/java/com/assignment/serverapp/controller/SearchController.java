package com.assignment.serverapp.controller;

import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/search")
    public List<Question> getSearchResult() {
        return (List<Question>) questionRepository.findAll();
    }
}
