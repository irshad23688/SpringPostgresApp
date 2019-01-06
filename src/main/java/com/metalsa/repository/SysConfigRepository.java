package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrSysConfigUt;

@Repository
public interface SysConfigRepository extends JpaRepository<MmrSysConfigUt, Long> {
	
	MmrSysConfigUt findByParamName(String paranName);
}
