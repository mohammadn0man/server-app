package com.assignment.serverapp.repository;

import com.assignment.serverapp.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
