package com.adithya.MAMS.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adithya.MAMS.entity.Base;

@Repository
public interface BaseRepo extends JpaRepository<Base, Long> {

}
