package com.greenlearner.product.service;

import com.greenlearner.product.dto.Product;
import com.greenlearner.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addProduct(Product product) {
        log.info("adding product");
        productRepository.save(product);
        return "success";
    }

    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> productCategoryList(String category) {
        return productRepository.findByCategory(category);
    }

    public Product productById(Integer id) {
       return productRepository.findById(id).get();
    }

    public String updateProduct(Product product) {
        productRepository.save(product);
        return "product updated successfully";
    }

    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return "product deleted";
    }
}