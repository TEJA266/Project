package com.example.product.controller;

import com.example.product.dto.ProductDTO;
import com.example.product.entity.Product;
import com.example.product.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/allProducts")
    public ResponseEntity<ArrayList<Product>> getAllProducts(){
        ArrayList<Product>   productsArrayList=new ArrayList<Product>();
        Iterable<Product> productIterator=productService.findAllProducts();
        for(Product product:productIterator){
            productsArrayList.add(product);
        }
        return new ResponseEntity<ArrayList<Product>>(productsArrayList,HttpStatus.OK);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO)
    {
        Product product=new Product();
        BeanUtils.copyProperties(productDTO,product);
        productService.addProduct(product);
        return new ResponseEntity<String>(product.getId(),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteproduct/{productId}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") String productId)
    {
       productService.deleteProduct(productId);

        return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.CREATED);
    }
}
