package com.example.product.services;

import com.example.product.entity.Product;
import org.springframework.stereotype.Service;

public interface ProductService {
    public void addProduct(Product product);
    public void deleteProduct(String productId);
    public Iterable<Product> findAllProducts();
}
