package com.example.ECOMMERCE.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class MerchantDTO {
    private String merchantId;
    private String name;
    private String email;
    private String password;
//    private List<Products> products;
    private String details;
    private Integer stock;
}
