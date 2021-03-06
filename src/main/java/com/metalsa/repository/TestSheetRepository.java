package com.metalsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrTestSheetUt;

@Repository
public interface TestSheetRepository extends JpaRepository<MmrTestSheetUt, Long> {
	
	List<MmrTestSheetUt> findByMmrClassMasterUtAndMmrSubclassMasterUt(Long classId,Long subClassId);
	
}
