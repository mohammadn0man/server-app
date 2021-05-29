package com.assignment.serverapp.repository;

import com.assignment.serverapp.model.Like;
import com.assignment.serverapp.model.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like, Integer> {
    List<Like> findByReply(Reply reply);
}
