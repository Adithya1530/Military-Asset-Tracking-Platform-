package com.adithya.MAMS.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adithya.MAMS.entity.Asset;

@Repository
public interface AssetRepo extends JpaRepository<Asset, Long> {
	
	List<Asset> findByCurrentBaseId(Long baseId);

}
