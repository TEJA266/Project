package com.example.ECOMMERCE.controller;

import com.example.ECOMMERCE.dto.MerchantDTO;
import com.example.ECOMMERCE.entity.Merchant;
import com.example.ECOMMERCE.services.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        return new ResponseEntity<String>(merchant.getMerchantId(),HttpStatus.CREATED);
    }
    @DeleteMapping("/merchantdelete/{merchantId}")
    public ResponseEntity<Boolean> deleteMerchant(@PathVariable("merchantId") String merchantId)
    {
        merchantService.deleteByMerchantId(merchantId);

        return new ResponseEntity<Boolean>(Boolean.TRUE,HttpStatus.CREATED);
    }
    @GetMapping("/getMerchantById/{merchantId}")
    public ResponseEntity<Object> findMerchant(@PathVariable("merchantId") String merchantId){
        Optional<Merchant> merchant = merchantService.findByMerchantId(merchantId);
        MerchantDTO merchantDTO = new MerchantDTO();
        if(merchant.isPresent()){
            BeanUtils.copyProperties(merchant.get(),merchantDTO);
            return new ResponseEntity<Object>(merchantDTO,HttpStatus.OK);
        }
        return new ResponseEntity<Object>("No data found for this identifier",HttpStatus.OK);
    }
}
