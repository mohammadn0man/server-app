package com.assignment.serverapp.repository;

import com.assignment.serverapp.model.ExpireToken;
import org.springframework.data.repository.CrudRepository;

public interface ExpireTokenRepository extends CrudRepository<ExpireToken, String> {
}
