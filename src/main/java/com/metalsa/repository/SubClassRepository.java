package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.SubclassMasterUt;

@Repository
public interface SubClassRepository extends JpaRepository<SubclassMasterUt, Long> {
	
}
