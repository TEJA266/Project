package com.example.Merchant.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MerchantDTO {

    private String emailId;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private Integer rating;
}
