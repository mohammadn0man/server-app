package com.assignment.serverapp.service;

import com.assignment.serverapp.model.Product;
import com.assignment.serverapp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /***
     * @return list of all the products
     */
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }
}
