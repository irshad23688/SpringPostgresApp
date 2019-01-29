package com.metalsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrNewDataSheetDetailView;

@Repository
public interface MmrNewDataSheetDetailViewRepository extends JpaRepository<MmrNewDataSheetDetailView, Long> {

	List<MmrNewDataSheetDetailView> findByClassIdAndSubClassId(Long classId,Long subClassId);
	
	List<MmrNewDataSheetDetailView> findByClassIdAndSubClassIdAndHeaderAttributeSequenceNo(Long classId,Long subClassId,Long headerAttributeSequenceNo);

	@Query(value = "select max(v.header_attribute_sequence_no) from mmr_new_data_sheet_detail_view v where v.class_id=?1 and v.subclass_id=?2", 
			nativeQuery=true)
	long getMaxHeaderCount(Long classId,Long subClassId);
	
	@Query(value = "select min(v.header_attribute_sequence_no) from mmr_new_data_sheet_detail_view v where v.class_id=?1 and v.subclass_id=?2", 
			nativeQuery=true)
	long getMinHeaderCount(Long classId,Long subClassId);
}
