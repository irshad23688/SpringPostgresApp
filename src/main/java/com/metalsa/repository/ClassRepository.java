package com.metalsa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrClassMasterUt;

@Repository
public interface ClassRepository extends JpaRepository<MmrClassMasterUt, Long> {
	
	List<MmrClassMasterUt> getClassByStatus(BigDecimal status);
}
