package com.greenlearner.product.repository;

import com.greenlearner.product.dto.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, Integer> {

    @Query("{'Category.name':?0}")
    List<Product> findByCategory(String category);
}
