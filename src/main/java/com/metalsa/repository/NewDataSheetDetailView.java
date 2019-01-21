package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrNewDataSheetDetailView;

@Repository
public interface NewDataSheetDetailView extends JpaRepository<MmrNewDataSheetDetailView, Long> {
	
	
}
