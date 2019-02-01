package com.metalsa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrRegionMasterUt;

@Repository
public interface RegionRepository extends JpaRepository<MmrRegionMasterUt, Long> {
	
	List<MmrRegionMasterUt> findByStatus(BigDecimal status);
}
