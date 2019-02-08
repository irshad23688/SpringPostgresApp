package com.metalsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrEditDataSheetDetailView;
import com.metalsa.domain.MmrNewDataSheetDetailView;

@Repository
public interface MmrEditDataSheetDetailViewRepository extends JpaRepository<MmrEditDataSheetDetailView, Long> {


	List<MmrEditDataSheetDetailView> findByDataSheetUtId(Long dataSheetId);
	List<MmrEditDataSheetDetailView> findByDataSheetUtIdAndHeaderAttributeSequenceNo(Long dataSheetId,Long headerAttributeSequenceNo);

	List<MmrNewDataSheetDetailView> findByClassIdAndSubClassIdAndHeaderAttributeSequenceNo(Long classId,Long subClassId,Long headerAttributeSequenceNo);

	@Query(value = "select max(v.header_attribute_sequence_no) from mmr_edit_data_sheet_detail_view v where v.mmr_data_sheet_ut_id=?1 ", 
			nativeQuery=true)
	long getMaxHeaderCount(long dataSheetId);

	@Query(value = "select min(v.header_attribute_sequence_no) from mmr_edit_data_sheet_detail_view v where v.mmr_data_sheet_ut_id=?1 ", 
			nativeQuery=true)
	long getMinHeaderCount(long dataSheetId);
}
