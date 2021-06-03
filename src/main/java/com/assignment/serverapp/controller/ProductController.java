package com.assignment.serverapp.controller;

import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/all_product")
    public List<Product> getProducts() {
        return productService.getAll();
    }

}
