package com.example.ECOMMERCE.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Merchant {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String merchantId;
    private String name;
    private String email;
    private String password;
//    @ManyToMany
//    @JoinTable(name="merchant_product_link",joinColumns={@JoinColumn(name="merchantId")},inverseJoinColumns={@JoinColumn(name="productId")})
//    private List<Products> products;
    private String details;
    private Integer stock;

}
