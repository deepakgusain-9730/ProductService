package com.learning.firstspringapi.controllers;

import com.learning.firstspringapi.dto.FakeStoreProductDto;
import com.learning.firstspringapi.models.Product;
import com.learning.firstspringapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // This controller going to host rest api
@RequestMapping("products") // products endpoint will come to this class from handler mapping by Dispatcher ServerLet
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
