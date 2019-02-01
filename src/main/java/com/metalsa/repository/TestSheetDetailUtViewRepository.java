package com.metalsa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrTestSheetDetailUtView;

@Repository
public interface TestSheetDetailUtViewRepository extends JpaRepository<MmrTestSheetDetailUtView, Long> {
	
	List<MmrTestSheetDetailUtView> findByMmrTestSheetUtId(Long mmrTestSheetUtId);
	List<MmrTestSheetDetailUtView> findByMmrTestSheetUtIdIn(List<Long> ids);
	
	 @Query(value = "SELECT rownum as id,\r\n" + 
	 		"case when testSheetDtl.id is null then 0 else testSheetDtl.id end as TEST_SHEET_DTL_ID,\r\n" + 
	 		"case when testSheetDtl.mmr_test_sheet_ut_id is null then 0 else testSheetDtl.mmr_test_sheet_ut_id end as mmr_test_sheet_ut_id,\r\n" + 
	 		"case when testsheetdtl.header_attribute_id is null then base.header_attribute_id else testsheetdtl.header_attribute_id end as header_attribute_id,\r\n" + 
	 		"header.name as header_attribute_name,\r\n" + 
	 		"case when testsheetdtl.base_attribute_id is null then base.id else testsheetdtl.base_attribute_id end as base_attribute_id,\r\n" + 
	 		"base.name as BASE_ATTRIBUTE_NAME,\r\n" + 
	 		"case when testsheetdtl.base_attribute_sequence_no is null then 0 else testsheetdtl.base_attribute_sequence_no end as base_attribute_sequence_no,\r\n" + 
	 		"case when testsheetdtl.header_attribute_sequence_no is null then 0 else testsheetdtl.header_attribute_sequence_no end as header_attribute_sequence_no,\r\n" + 
	 		"case when testsheetdtl.ismanadatory is null then 0 else testsheetdtl.ismanadatory end as ismanadatory,\r\n" + 
	 		"case when testsheetdtl.status is null then base.status else testsheetdtl.status end as status\r\n" + 
	 		"FROM\r\n" + 
	 		"    mmr_base_attribute_master_ut base\r\n" + 
	 		"        LEFT JOIN mmr_header_attribute_master_ut header ON base.header_attribute_id = header.id\r\n" + 
	 		"        LEFT JOIN mmr_test_sheet_detail_ut testSheetDtl ON base.id = testSheetDtl.base_attribute_id\r\n" + 
	 		"        AND testsheetdtl.status=1 AND base.status= 1 AND header.status = 1 \r\n" + 
	 		"        AND testSheetDtl.mmr_test_sheet_ut_id =?1\r\n" + 
	 		"        ORDER BY testsheetdtl.base_attribute_sequence_no,testsheetdtl.header_attribute_id", 
		        nativeQuery=true
		    )
	 List<MmrTestSheetDetailUtView> findByTestSheetDetail(Long mmrTestSheetUtId);
}
