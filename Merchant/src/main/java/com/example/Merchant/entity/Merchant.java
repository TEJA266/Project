package com.example.Merchant.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@ToString
@Document(collection = "Merchant")
public class Merchant {
    @Id
    private String emailId;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private Integer rating;

}
