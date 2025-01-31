package com.learning.firstspringapi.controllers;

import com.learning.firstspringapi.dto.FakeStoreProductDto;
import com.learning.firstspringapi.models.Product;
import com.learning.firstspringapi.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController // This controller going to host rest api
@RequestMapping("products") // products endpoint will come to this class from handler mapping by Dispatcher ServerLet
public class ProductController {


    private ProductService productService;

    public ProductController(@Qualifier("SelfProductService") ProductService productService) {
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

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
            Product product1 = productService.updateProduct(id, product);
            return new ResponseEntity<Product>(product1, HttpStatus.OK);

    }
}
