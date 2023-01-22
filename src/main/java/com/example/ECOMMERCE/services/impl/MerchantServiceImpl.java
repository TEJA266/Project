package com.example.ECOMMERCE.services.impl;

import com.example.ECOMMERCE.entity.Merchant;
import com.example.ECOMMERCE.repository.MerchantRepository;
import com.example.ECOMMERCE.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;
    public void addOrUpdateMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }
    public void deleteByMerchantId(String merchantId){merchantRepository.deleteById(merchantId);}

    @Override
    public Optional<Merchant> findByMerchantId(String merchantId) {
       return merchantRepository.findById(merchantId);
    }



}
