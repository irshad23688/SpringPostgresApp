package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.ManufacturerMasterUt;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerMasterUt, Long> {
	
}
