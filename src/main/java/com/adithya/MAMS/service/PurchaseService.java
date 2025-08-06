package com.adithya.MAMS.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adithya.MAMS.entity.Purchase;
import com.adithya.MAMS.repo.PurchaseRepo;

@Service
public class PurchaseService {
	
	@Autowired
	private PurchaseRepo purchaseRepository ;
	
	public Purchase createPurchase(Purchase purchase) {
        purchase.setPurchaseDate(LocalDate.now());
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Purchase not found"));
    }

    public void deletePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }

    public List<Purchase> getPurchasesByBase(Long baseId) {
        return purchaseRepository.findByBaseId(baseId);
    }

}
