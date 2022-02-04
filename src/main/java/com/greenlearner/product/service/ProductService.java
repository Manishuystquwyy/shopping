package com.greenlearner.product.service;

import com.greenlearner.product.dto.Product;
import com.greenlearner.product.exception.CurrencyNotValidException;
import com.greenlearner.product.exception.OfferNotValidException;
import com.greenlearner.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        if(product.getPrice() == 0 && product.getDiscount() > 0){
            throw new OfferNotValidException("No Discount is allowed at 0 product price");
        }

        List<String> validCurrencies = new ArrayList<>();
        validCurrencies.add("INR");
        validCurrencies.add("USD");
        validCurrencies.add("EUR");
        if(!validCurrencies.contains(product.getCurrency().toUpperCase())){
            throw new CurrencyNotValidException("Invalid Currency. Valid currencies- "+ validCurrencies);
        }
        productRepository.save(product);
        return "success";
    }

    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> productCategoryList(String category) {
        return productRepository.findByCategory(category);
    }

    public Product productById(String id) {
       return productRepository.findById(id).get();
    }

    public String updateProduct(Product product) {
        productRepository.save(product);
        return "product updated successfully";
    }

    public String deleteProductById(String id) {
        productRepository.deleteById(id);
        return "product deleted";
    }
}
