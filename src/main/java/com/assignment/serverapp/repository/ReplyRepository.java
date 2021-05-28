package com.assignment.serverapp.repository;

import com.assignment.serverapp.model.Question;
import com.assignment.serverapp.model.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReplyRepository extends CrudRepository<Reply, Integer> {
    List<Reply> findByQuestion(Question question);
}
