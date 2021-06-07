package com.assignment.serverapp.service;

import com.assignment.serverapp.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final QuestionService questionService;

    /***
     * simple search functionality
     * @param spec parameter for search query
     * @param sort parameter for sorting type
     * @return list of questions in desired order
     */
    public List<Question> get(Specification<Question> spec, Sort sort) {
        return questionService.search(spec, sort);
    }
}
