package com.example.product.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private String productName;
    private String brand;
    private String description;
    private Integer price;
    private String imgSrc;

}
