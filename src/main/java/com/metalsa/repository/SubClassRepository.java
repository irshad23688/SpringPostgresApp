package com.metalsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrClassMasterUt;
import com.metalsa.domain.MmrSubClassMasterUt;

@Repository
public interface SubClassRepository extends JpaRepository<MmrSubClassMasterUt, Long> {
	
	List<MmrSubClassMasterUt> findByMmrClassMasterUt(MmrClassMasterUt masterUt);
	
}
