package com.assignment.serverapp.repository;

import com.assignment.serverapp.model.Like;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Integer> {
}
