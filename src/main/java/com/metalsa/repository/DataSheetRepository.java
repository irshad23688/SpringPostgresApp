package com.metalsa.repository;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrDataSheetUt;

@Repository

public interface DataSheetRepository extends JpaRepository<MmrDataSheetUt, Long> {
	
	/*@Query(value = "update MMR_DATA_SHEET_UT datasheet set datasheet.status = ?1  where datasheet.id = ?2" , 
		        nativeQuery=true
		    )
	int setStatusForDataSheet(@Param("status") Long status, @Param("id") Long id);
	
	@Transactional
	@Modifying(clearAutomatically = true)
    @Query("update MmrDataSheetUt datasheet set datasheet.status = ?1  where datasheet.id = ?2")
    int updateDataSheet(@Param("status") BigDecimal status, @Param("id") Long id);*/
	
//	void setStatus(BigDecimal status,Long id);
	
	 @Modifying(clearAutomatically = true)
	 @Transactional
	@Query("update MmrDataSheetUt u set u.status = :status where u.id = :id")
	int updateMmrDataSheetUtSetStatusForId(@Param("status") BigDecimal status, @Param("id") Long id);
	 
	 @Query(value = "select max(v.revision)from mmr_data_sheet_ut v where v.class_id=?1 and v.subclass_id=?2 and v.region_id=?3", 
				nativeQuery=true)
		String getMaxHeaderCount(Long classId,Long subClassId,Long regionId);
}
