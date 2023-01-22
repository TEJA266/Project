package com.example.ECOMMERCE.services;

import com.example.ECOMMERCE.entity.Merchant;

import java.util.Optional;

public interface MerchantService {
public void addOrUpdateMerchant(Merchant merchant);
public void deleteByMerchantId(String merchantId);
public Optional<Merchant> findByMerchantId(String merchantId);

}
