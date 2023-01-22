package com.example.ECOMMERCE.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
public class UsersDTO {

    @Id
    private String user_id;

    private String user_name;

    private String user_email;

    private String user_password;




}