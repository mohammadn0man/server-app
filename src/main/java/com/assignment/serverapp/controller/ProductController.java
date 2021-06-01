package com.assignment.serverapp.controller;

import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: 31-05-2021 add product api
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/all_product")
    public List<Product> getProducts(){
        return (List<Product>) productRepository.findAll();
    }



}
