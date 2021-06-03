package com.assignment.serverapp.service;

import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }
}
