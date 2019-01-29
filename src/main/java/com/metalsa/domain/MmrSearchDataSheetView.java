package com.metalsa.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="SEARCH_DATASHEET_VIEW")
public class MmrSearchDataSheetView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "ID")
    private Long id; 
	
	@Column(name ="DATA_SHEET_ID")
	private long dataSheetId;

	@Column(name ="BASE_ATTRIBUTE_ID")
	private long baseAttributeId;

	@Column(name ="TEST_SHEET_ID")
	private long testSheetId;

	@Column(name ="BASE_ATTRIBUTE_NAME")
	private String baseAttributeName;

	@Column(name ="TESTING_INFORMATION")
	private String testingInformation;

	@Column(name ="REVISION")
	private String revision;

	@Column(name ="SUPPLIER_INFO")
	private String supplierInfo;
	
	@Column(name ="SOM1_UOM")
	private String som1Uom;
	
	@Column(name ="USER_UOM1")
	private String userUom1;
	
	@Column(name ="SOM2_UOM")
	private String som2Uom;
	
	@Column(name ="USER_UOM2")
	private String userUom2;
	
	@Column(name ="STATUS")
	private long status;
	
	@Transient
	private Map<String, String> uomMap = new LinkedHashMap<>();

	public long getDataSheetId() {
		return dataSheetId;
	}

	public void setDataSheetId(long dataSheetId) {
		this.dataSheetId = dataSheetId;
	}

	public long getBaseAttributeId() {
		return baseAttributeId;
	}

	public void setBaseAttributeId(long baseAttributeId) {
		this.baseAttributeId = baseAttributeId;
	}

	public long getTestSheetId() {
		return testSheetId;
	}

	public void setTestSheetId(long testSheetId) {
		this.testSheetId = testSheetId;
	}

	public String getBaseAttributeName() {
		return baseAttributeName;
	}

	public void setBaseAttributeName(String baseAttributeName) {
		this.baseAttributeName = baseAttributeName;
	}

	public String getTestingInformation() {
		return testingInformation;
	}

	public void setTestingInformation(String testingInformation) {
		this.testingInformation = testingInformation;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getSupplierInfo() {
		return supplierInfo;
	}

	public void setSupplierInfo(String supplierInfo) {
		this.supplierInfo = supplierInfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSom1Uom() {
		return som1Uom;
	}

	public void setSom1Uom(String som1Uom) {
		this.som1Uom = som1Uom;
	}

	public String getUserUom1() {
		return userUom1;
	}

	public void setUserUom1(String userUom1) {
		this.userUom1 = userUom1;
	}

	public String getSom2Uom() {
		return som2Uom;
	}

	public void setSom2Uom(String som2Uom) {
		this.som2Uom = som2Uom;
	}

	public String getUserUom2() {
		return userUom2;
	}

	public void setUserUom2(String userUom2) {
		this.userUom2 = userUom2;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (baseAttributeId ^ (baseAttributeId >>> 32));
		result = prime * result + ((baseAttributeName == null) ? 0 : baseAttributeName.hashCode());
		result = prime * result + (int) (dataSheetId ^ (dataSheetId >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((revision == null) ? 0 : revision.hashCode());
		result = prime * result + ((som1Uom == null) ? 0 : som1Uom.hashCode());
		result = prime * result + ((som2Uom == null) ? 0 : som2Uom.hashCode());
		result = prime * result + (int) (status ^ (status >>> 32));
		result = prime * result + ((supplierInfo == null) ? 0 : supplierInfo.hashCode());
		result = prime * result + (int) (testSheetId ^ (testSheetId >>> 32));
		result = prime * result + ((testingInformation == null) ? 0 : testingInformation.hashCode());
		result = prime * result + ((userUom1 == null) ? 0 : userUom1.hashCode());
		result = prime * result + ((userUom2 == null) ? 0 : userUom2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MmrSearchDataSheetView other = (MmrSearchDataSheetView) obj;
		if (baseAttributeId != other.baseAttributeId)
			return false;
		if (baseAttributeName == null) {
			if (other.baseAttributeName != null)
				return false;
		} else if (!baseAttributeName.equals(other.baseAttributeName))
			return false;
		if (dataSheetId != other.dataSheetId)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (revision == null) {
			if (other.revision != null)
				return false;
		} else if (!revision.equals(other.revision))
			return false;
		if (som1Uom == null) {
			if (other.som1Uom != null)
				return false;
		} else if (!som1Uom.equals(other.som1Uom))
			return false;
		if (som2Uom == null) {
			if (other.som2Uom != null)
				return false;
		} else if (!som2Uom.equals(other.som2Uom))
			return false;
		if (status != other.status)
			return false;
		if (supplierInfo == null) {
			if (other.supplierInfo != null)
				return false;
		} else if (!supplierInfo.equals(other.supplierInfo))
			return false;
		if (testSheetId != other.testSheetId)
			return false;
		if (testingInformation == null) {
			if (other.testingInformation != null)
				return false;
		} else if (!testingInformation.equals(other.testingInformation))
			return false;
		if (userUom1 == null) {
			if (other.userUom1 != null)
				return false;
		} else if (!userUom1.equals(other.userUom1))
			return false;
		if (userUom2 == null) {
			if (other.userUom2 != null)
				return false;
		} else if (!userUom2.equals(other.userUom2))
			return false;
		return true;
	}

	public Map<String, String> getUomMap() {
		return uomMap;
	}

	public void setUomMap(Map<String, String> uomMap) {
		this.uomMap = uomMap;
	}
	
	
	
	
}
