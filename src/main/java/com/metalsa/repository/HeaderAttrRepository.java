package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.HeaderAttributeMasterUt;

@Repository
public interface HeaderAttrRepository extends JpaRepository<HeaderAttributeMasterUt, Long> {
	
}
