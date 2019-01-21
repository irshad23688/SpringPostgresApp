package com.metalsa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metalsa.domain.MmrHeaderAttributeMasterUt;

@Repository
public interface HeaderAttrRepository extends JpaRepository<MmrHeaderAttributeMasterUt, Long> {
	
	List<MmrHeaderAttributeMasterUt> findByIstableheaderFlagAndStatus(BigDecimal istableheaderFlag,BigDecimal status);
	List<MmrHeaderAttributeMasterUt> getHeaderByStatus(BigDecimal status);


}
