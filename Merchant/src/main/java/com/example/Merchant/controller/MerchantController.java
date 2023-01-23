package com.example.Merchant.controller;

import com.example.Merchant.dto.MerchantDTO;
import com.example.Merchant.entity.Merchant;
import com.example.Merchant.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
@RestController
public class MerchantController {
    @Autowired
    MerchantService merchantService;
    @PostMapping("/addOrUpdateMerchant")
    public ResponseEntity<String> addOrUpdateMerchant(@RequestBody MerchantDTO merchantDTO)
    {
        Merchant merchant=new Merchant();
        BeanUtils.copyProperties(merchantDTO,merchant);
        merchantService.addOrUpdateMerchant(merchant);

        return new ResponseEntity<String>(merchant.getEmailId(),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteMerchant/{emailId}")
    public ResponseEntity<Boolean> deleteMerchant(@PathVariable("emailId") String emailId)
    {
        merchantService.deleteMerchant(emailId);

        return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.CREATED);
    }
    @GetMapping("/getMerchantById/{emailId}")
    public ResponseEntity<Object> findMerchant(@PathVariable("emailId") String emailId){
        Optional<Merchant> merchant = merchantService.findById(emailId);
        MerchantDTO merchantDTO = new MerchantDTO();
        if(merchant.isPresent()){
            BeanUtils.copyProperties(merchant.get(),merchantDTO);
            return new ResponseEntity<Object>(merchant,HttpStatus.OK);
        }
        else
        return new ResponseEntity<Object>("No data found for this identifier",HttpStatus.OK);
    }
    @GetMapping("/MerchantList")
    public ResponseEntity<ArrayList<Merchant>> getAllMerchants(){
        ArrayList<Merchant>   merchantsArrayList=new ArrayList<Merchant>();
        Iterable<Merchant> merchantIterable=merchantService.findMerchantList();
        for(Merchant merchant:merchantIterable){
            merchantsArrayList.add(merchant);
        }
        return new ResponseEntity<ArrayList<Merchant>>(merchantsArrayList,HttpStatus.OK);
    }
}
