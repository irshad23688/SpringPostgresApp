package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.ClassMasterUt;

@Repository
public interface ClassRepository extends JpaRepository<ClassMasterUt, Long> {
	
}
