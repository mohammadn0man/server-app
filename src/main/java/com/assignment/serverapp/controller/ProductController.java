package com.assignment.serverapp.controller;

import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    /***
     * @return list of all the products
     */
    @GetMapping("/get")
    public List<Product> getProducts() {
        return productService.getAll();
    }

}
