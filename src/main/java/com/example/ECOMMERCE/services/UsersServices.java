package com.example.ECOMMERCE.services;

import com.example.ECOMMERCE.dto.UsersDTO;
import com.example.ECOMMERCE.entity.Users;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsersServices {

    public void addOrUpdateUser(Users user);
    public void deleteByUserId(String userId);
    public Optional<Users> findByUserId(String userId);


}
