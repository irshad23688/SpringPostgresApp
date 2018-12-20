package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrBaseAttributeMasterUt;

@Repository
public interface BaseAttributeRepository extends JpaRepository<MmrBaseAttributeMasterUt, Long> {
	
}
