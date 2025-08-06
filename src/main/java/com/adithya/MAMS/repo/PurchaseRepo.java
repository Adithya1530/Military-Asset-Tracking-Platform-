package com.adithya.MAMS.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adithya.MAMS.entity.Expenditure;
import com.adithya.MAMS.entity.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
	
	public List<Purchase> findByBaseId(Long baseId) ;

}
