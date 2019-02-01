package com.metalsa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrManufacturerMasterUt;

@Repository
public interface ManufacturerRepository extends JpaRepository<MmrManufacturerMasterUt, Long> {

	List<MmrManufacturerMasterUt> findByStatus(BigDecimal status);
}
