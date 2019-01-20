package com.metalsa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrEditDataSheetDetailView;

@Repository
public interface EditDataSheetDetailView extends JpaRepository<MmrEditDataSheetDetailView, Long> {
	
}
