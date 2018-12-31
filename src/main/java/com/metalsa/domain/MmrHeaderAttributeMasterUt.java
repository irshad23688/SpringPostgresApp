package com.metalsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the MMR_HEADER_ATTRIBUTE_MASTER_UT database table.
 * 
 */
@Entity
@Table(name="MMR_HEADER_ATTRIBUTE_MASTER_UT")
public class MmrHeaderAttributeMasterUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", nullable=false)
	private Timestamp createdOn;

	@Column(nullable=false, length=500)
	private String description;

	@Column(name="ISTABLEHEADER_FLAG", length=3)
	private BigDecimal istableheaderFlag;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;
	
	@Column(name="ISSTATIC_FLAG")
	private BigDecimal isstaticFlag;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, precision=38)
	private BigDecimal status;
	
	/*@Column(name="IS_SEARCH",nullable=false, precision=38)
	private BigDecimal isSearch;*/

	//bi-directional many-to-one association to MmrBaseAttributeMasterUt
	@OneToMany(mappedBy="mmrHeaderAttributeMasterUt")
	@JsonBackReference
	private List<MmrBaseAttributeMasterUt> mmrBaseAttributeMasterUts;

	/*//bi-directional many-to-one association to MmrBaseAttributeTableDataTypeUt
	@OneToMany(mappedBy="mmrHeaderAttributeMasterUt")
	private List<MmrBaseAttributeTableDataTypeUt> mmrBaseAttributeTableDataTypeUts;

	//bi-directional many-to-one association to MmrTestSheetDetailUt
	@OneToMany(mappedBy="mmrHeaderAttributeMasterUt")
	private List<MmrTestSheetDetailUt> mmrTestSheetDetailUts;*/

	public MmrHeaderAttributeMasterUt() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getIsstaticFlag() {
		return isstaticFlag;
	}

	public void setIsstaticFlag(BigDecimal isstaticFlag) {
		this.isstaticFlag = isstaticFlag;
	}

	public void setIstableheaderFlag(BigDecimal istableheaderFlag) {
		this.istableheaderFlag = istableheaderFlag;
	}
	
	

	public List<MmrBaseAttributeMasterUt> getMmrBaseAttributeMasterUts() {
		return this.mmrBaseAttributeMasterUts;
	}

	public void setMmrBaseAttributeMasterUts(List<MmrBaseAttributeMasterUt> mmrBaseAttributeMasterUts) {
		this.mmrBaseAttributeMasterUts = mmrBaseAttributeMasterUts;
	}

	public MmrBaseAttributeMasterUt addMmrBaseAttributeMasterUt(MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt) {
		getMmrBaseAttributeMasterUts().add(mmrBaseAttributeMasterUt);
//		mmrBaseAttributeMasterUt.setMmrHeaderAttributeMasterUt(this.mmrBaseAttributeMasterUts);

		return mmrBaseAttributeMasterUt;
	}

	public MmrBaseAttributeMasterUt removeMmrBaseAttributeMasterUt(MmrBaseAttributeMasterUt mmrBaseAttributeMasterUt) {
		getMmrBaseAttributeMasterUts().remove(mmrBaseAttributeMasterUt);
		mmrBaseAttributeMasterUt.setMmrHeaderAttributeMasterUt(null);

		return mmrBaseAttributeMasterUt;
	}

	/*public BigDecimal getIsSearch() {
		return isSearch;
	}

	public void setIsSearch(BigDecimal isSearch) {
		this.isSearch = isSearch;
	}*/

	public BigDecimal getIstableheaderFlag() {
		return istableheaderFlag;
	}
	
	

 
}