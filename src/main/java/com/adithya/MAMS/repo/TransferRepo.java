package com.adithya.MAMS.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adithya.MAMS.entity.Transfer;

@Repository
public interface TransferRepo extends JpaRepository<Transfer, Long> {
	
	public List<Transfer> findByFromBaseId(Long baseId) ;

    public List<Transfer> findByToBaseId(Long baseId) ;
}
