package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrDataTypeMasterUt;

@Repository
public interface DataTypeRepository extends JpaRepository<MmrDataTypeMasterUt, Long> {
	
}
