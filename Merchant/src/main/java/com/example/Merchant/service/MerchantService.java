package com.example.Merchant.service;

import com.example.Merchant.entity.Merchant;

import java.util.Optional;

public interface MerchantService {
    public Iterable<Merchant> findMerchantList();
    public void addOrUpdateMerchant(Merchant merchant);
    public void deleteMerchant(String merchantId);
    public Optional<Merchant> findById(String merchantId);
}
