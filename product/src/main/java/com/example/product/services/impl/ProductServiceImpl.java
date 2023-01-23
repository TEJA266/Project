package com.example.product.services.impl;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Iterable<Product> findAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);

    }
}
