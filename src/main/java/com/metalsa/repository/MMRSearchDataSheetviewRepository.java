package com.metalsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrSearchDataSheetView;

@Repository
public interface MMRSearchDataSheetviewRepository extends JpaRepository<MmrSearchDataSheetView, Long> {
	
	List<MmrSearchDataSheetView> getViewByBaseAttributeId(long id);
}
