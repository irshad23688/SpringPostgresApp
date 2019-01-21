package com.metalsa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrBaseAttributeMasterUt;

@Repository
public interface BaseAttributeRepository extends JpaRepository<MmrBaseAttributeMasterUt, Long> {
	
	List<MmrBaseAttributeMasterUt> getBaseAttribByStatus(BigDecimal status);
}
