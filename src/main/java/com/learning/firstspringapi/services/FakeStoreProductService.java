package com.learning.firstspringapi.services;

import com.learning.firstspringapi.dto.FakeStoreProductDto;
import com.learning.firstspringapi.models.Category;
import com.learning.firstspringapi.models.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImage(fakeStoreProductDto.getImage());
        product.setTitle(fakeStoreProductDto.getTitle());
        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }


    @Override
    public Product getProductById(Long id) throws RuntimeException {
        FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/1" + id, FakeStoreProductDto.class);
        if(fakeStoreProductDto == null)
            throw new RuntimeException("No product found with id: " + id);
        return convertFakeProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts(){
        List<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.exchange(
                "https://fakestoreapi.com/products/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FakeStoreProductDto>>() {}
        ).getBody();
        if(fakeStoreProductDtos == null)
            return new ArrayList<>();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }
}
