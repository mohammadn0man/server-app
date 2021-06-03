package com.assignment.serverapp.repository;

import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Integer>, JpaSpecificationExecutor<Question> {
    List<Question> findByUser(User user);
    List<Question> findByProduct(Product product);
}
