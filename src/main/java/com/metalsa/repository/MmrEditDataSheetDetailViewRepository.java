package com.metalsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrEditDataSheetDetailView;

@Repository
public interface MmrEditDataSheetDetailViewRepository extends JpaRepository<MmrEditDataSheetDetailView, Long> {
	
	 
	 List<MmrEditDataSheetDetailView> findByDataSheetUtId(Long dataSheetId);
}
