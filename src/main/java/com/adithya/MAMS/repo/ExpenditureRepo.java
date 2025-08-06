package com.adithya.MAMS.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adithya.MAMS.entity.Purchase;

@Repository
public interface ExpenditureRepo extends JpaRepository<Purchase, Long> {

}
