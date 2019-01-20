package com.metalsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrNewDataSheetDetailView;

@Repository
public interface MmrNewDataSheetDetailViewRepository extends JpaRepository<MmrNewDataSheetDetailView, Long> {
	 
	 List<MmrNewDataSheetDetailView> findByClassIdAndSubClassId(Long classId,Long subClassId);
}
