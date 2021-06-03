package com.assignment.serverapp.service;

import com.assignment.serverapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    QuestionService questionService;

    public List<Question> get(Specification<Question> spec, Sort sort) {
        return questionService.search(spec, sort);
    }
}
