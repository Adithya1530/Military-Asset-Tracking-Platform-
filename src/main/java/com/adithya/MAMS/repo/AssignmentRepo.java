package com.adithya.MAMS.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adithya.MAMS.entity.Assignment;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment, Long> {
	
	List<Assignment> findByAssignedById(Long userId);
    List<Assignment> findByAssetId(Long assetId);
}
