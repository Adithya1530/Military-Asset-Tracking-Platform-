package com.adithya.MAMS.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adithya.MAMS.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.base.id = :baseId")
	List<User> findByBaseId(@Param("baseId") Long baseId);

}
