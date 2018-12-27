package com.metalsa.repository;

import java.util.List;

import com.metalsa.domain.MmrDataSheetUt;
import com.metalsa.domain.MmrTestSheetUt;

public interface CustomRepository {

	List<MmrDataSheetUt> getDataSheetByClassNSubclass(Long classId, Long subClassId);
	MmrTestSheetUt getTestSheetByClassNSubclass(Long classId, Long subClassId);
	void saveOrUpdate(Object obj);

}
