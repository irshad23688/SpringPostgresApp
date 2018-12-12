package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.BaseAttributeMasterUt;

@Repository
public interface BaseAttributeRepository extends JpaRepository<BaseAttributeMasterUt, Long> {
	
}
