package com.learning.firstspringapi.services;

import com.learning.firstspringapi.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Long id);
    public List<Product> getAllProducts();

    public Product updateProduct(Long id, Product product);
}
