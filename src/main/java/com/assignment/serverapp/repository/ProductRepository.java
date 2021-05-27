package com.assignment.serverapp.repository;

import com.assignment.serverapp.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
