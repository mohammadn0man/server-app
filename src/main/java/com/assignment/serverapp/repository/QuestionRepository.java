package com.assignment.serverapp.repository;

import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    List<Question> findByUser(User user);
    List<Question> findByProduct(Product product);
}
