package com.example.ECOMMERCE.entity;


import lombok.Data;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

@Data
@Entity
@Table(name = Users.TABLE_NAME)
public class Users
{
    public static final String TABLE_NAME = "users";
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PASSWORD = "user_password";


    @Id
    @Column(name = Users.USER_ID)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String user_id;

    @Column(name = Users.USER_NAME)
    private String user_name;

    @Column(name = Users.USER_EMAIL)
    private String user_email;

    @Column(name = Users.USER_PASSWORD)
    private String user_password;


}

