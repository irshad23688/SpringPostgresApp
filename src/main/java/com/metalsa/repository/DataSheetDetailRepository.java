package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrDataSheetDetailUt;

@Repository
public interface DataSheetDetailRepository extends JpaRepository<MmrDataSheetDetailUt, Long> {
	
}