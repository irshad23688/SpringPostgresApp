package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrDataSheetUt;

@Repository
public interface DataSheetRepository extends JpaRepository<MmrDataSheetUt, Long> {
	
}
