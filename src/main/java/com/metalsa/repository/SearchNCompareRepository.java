package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metalsa.domain.MmrSearchDataSheetView;


public interface SearchNCompareRepository extends JpaRepository<MmrSearchDataSheetView, Long> {

	
}
