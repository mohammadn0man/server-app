package com.assignment.serverapp.service;

import com.assignment.serverapp.dto.QuestionDto;
import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.User;
import com.assignment.serverapp.repository.QuestionRepository;
import com.assignment.serverapp.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public boolean save(QuestionDto questionDto) {
        var question = MapperUtil.getModelMapper().map(questionDto, Question.class);
        question.setCreationDate(new Date());
        try {
            questionRepository.save(question);
        } catch (Exception e) {
            log.error("error in adding request : " + e);
            return false;
        }
        return true;
    }

    public List<Question> getAll() {
        return (List<Question>) questionRepository.findAll();
    }


    public List<Question> getByUserId(int id) {
        return questionRepository.findByUser(User.builder().userId(id).build());
    }

    public List<Question> getByProductId(int id) {
        return questionRepository.findByProduct(Product.builder().productId(id).build());
    }

    public List<Question> search(Specification<Question> spec, Sort sort) {
        return questionRepository.findAll(spec, sort);
    }

    public long getCount() {
        return questionRepository.count();
    }
}
