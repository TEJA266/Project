package com.example.ECOMMERCE.controller;



import com.example.ECOMMERCE.dto.UsersDTO;
import com.example.ECOMMERCE.entity.Users;
import com.example.ECOMMERCE.services.UsersServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.Optional;


@RestController
public class UsersController {


    @Autowired
    UsersServices usersServices;


    @PostMapping(value = "/addOrUpdateUser")
    public ResponseEntity<String> addOrUpdateUsers(@RequestBody UsersDTO usersDTO)
    {
        Users users=new Users();
        BeanUtils.copyProperties(usersDTO,users);
        usersServices.addOrUpdateUser(users);

        return new ResponseEntity<String>(users.getUser_id(),HttpStatus.CREATED);
    }


    @GetMapping(value = "/getUser/{userId}")
    public ResponseEntity<Object> findUser(@PathVariable("userId") String userId){
        Optional<Users> user = usersServices.findByUserId(userId);
        UsersDTO usersDTO=new UsersDTO();
        if(user.isPresent()){
            BeanUtils.copyProperties(user.get(),usersDTO);
            return new ResponseEntity<Object>(usersDTO,HttpStatus.OK);
        }
        return new ResponseEntity<Object>("No data found for this identifier",HttpStatus.OK);
    }



    @DeleteMapping(value = "/deleteUser/{userId}")
    public ResponseEntity<Boolean> deleteMerchant(@PathVariable("userId") String userId)
    {
        usersServices.deleteByUserId(userId);

        return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.CREATED);
    }



}
