package com.example.Merchant.service.impl;

import com.example.Merchant.entity.Merchant;
import com.example.Merchant.repository.MerchantRepository;
import com.example.Merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Iterable<Merchant> findMerchantList() {
        return merchantRepository.findAll();
    }

    @Override
    public void addOrUpdateMerchant(Merchant merchant) {
        merchantRepository.save(merchant);
    }

    @Override
    public void deleteMerchant(String emailId) {
        merchantRepository.deleteById(emailId);

    }

    @Override
    public Optional<Merchant> findById(String emailId) {
        return merchantRepository.findById(emailId);
    }
}
