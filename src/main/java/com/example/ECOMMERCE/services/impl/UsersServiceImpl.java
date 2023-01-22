package com.example.ECOMMERCE.services.impl;

import com.example.ECOMMERCE.dto.UsersDTO;
import com.example.ECOMMERCE.entity.Users;
import com.example.ECOMMERCE.repository.UsersRepository;
import com.example.ECOMMERCE.services.UsersServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersServices {
    @Autowired
    UsersRepository usersRepository;


    @Override
    public void addOrUpdateUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void deleteByUserId(String userId) {
        usersRepository.deleteById(userId);

    }

    @Override
    public Optional<Users> findByUserId(String userId) {
        return usersRepository.findById(userId);
    }
}
