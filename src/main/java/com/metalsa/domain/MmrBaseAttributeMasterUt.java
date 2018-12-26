package com.metalsa.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the MMR_BASE_ATTRIBUTE_MASTER_UT database table.
 * 
 */
@Entity
@Table(name="MMR_BASE_ATTRIBUTE_MASTER_UT")
public class MmrBaseAttributeMasterUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", nullable=false)
	private Timestamp createdOn;

	@Column(name="DEFAULT_VALUE", length=50)
	private String defaultValue;

	@Column(nullable=false, length=500)
	private String description;

	@Column(name="DISPLAY_NAME_UOM1", nullable=false, length=50)
	private String displayNameUom1;

	@Column(name="DISPLAY_NAME_UOM2", nullable=false, length=50)
	private String displayNameUom2;

	@Column(name="PLACE_HOLDER_TEXT", nullable=false, length=100)
	private String placeHolderText;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, precision=38)
	private BigDecimal status;

	@Column(nullable=false, length=50)
	private String symbol;

	@Column(nullable=false, length=100)
	private String tooltip;

	//bi-directional many-to-one association to MmrDataTypeMasterUt
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="DATA_TYPE_ID", nullable=false)
	private MmrDataTypeMasterUt mmrDataTypeMasterUt;


	@Column(name="HEADER_ATTRIBUTE_ID",nullable=false)
	private Long mmrHeaderAttributeMasterUt;
	
	/*@Column(name="IS_SEARCH",nullable=false, precision=38)
	private BigDecimal isSearch;*/

	//bi-directional many-to-one association to MmrBaseAttributeUomDetailsUt
	@OneToMany(mappedBy="mmrBaseAttributeMasterUt", cascade = CascadeType.ALL,  fetch=FetchType.EAGER)
	private List<MmrBaseAttributeUomDetailsUt> mmrBaseAttributeUomDetailsUts;


	public MmrBaseAttributeMasterUt() {
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

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
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

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getTooltip() {
		return this.tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public MmrDataTypeMasterUt getMmrDataTypeMasterUt() {
		return this.mmrDataTypeMasterUt;
	}

	public void setMmrDataTypeMasterUt(MmrDataTypeMasterUt mmrDataTypeMasterUt) {
		this.mmrDataTypeMasterUt = mmrDataTypeMasterUt;
	}

	public void setMmrHeaderAttributeMasterUt(Long mmrHeaderAttributeMasterUt) {
		this.mmrHeaderAttributeMasterUt = mmrHeaderAttributeMasterUt;
	}
	

	 
	/*public List<MmrBaseAttributeTableDataTypeUt> getMmrBaseAttributeTableDataTypeUts() {
		return this.mmrBaseAttributeTableDataTypeUts;
	}

	public void setMmrBaseAttributeTableDataTypeUts(List<MmrBaseAttributeTableDataTypeUt> mmrBaseAttributeTableDataTypeUts) {
		this.mmrBaseAttributeTableDataTypeUts = mmrBaseAttributeTableDataTypeUts;
	}

	public MmrBaseAttributeTableDataTypeUt addMmrBaseAttributeTableDataTypeUt(MmrBaseAttributeTableDataTypeUt mmrBaseAttributeTableDataTypeUt) {
		getMmrBaseAttributeTableDataTypeUts().add(mmrBaseAttributeTableDataTypeUt);
		mmrBaseAttributeTableDataTypeUt.setMmrBaseAttributeMasterUt(this);

		return mmrBaseAttributeTableDataTypeUt;
	}

	public MmrBaseAttributeTableDataTypeUt removeMmrBaseAttributeTableDataTypeUt(MmrBaseAttributeTableDataTypeUt mmrBaseAttributeTableDataTypeUt) {
		getMmrBaseAttributeTableDataTypeUts().remove(mmrBaseAttributeTableDataTypeUt);
		mmrBaseAttributeTableDataTypeUt.setMmrBaseAttributeMasterUt(null);

		return mmrBaseAttributeTableDataTypeUt;
	}*/

	public Long getMmrHeaderAttributeMasterUt() {
		return mmrHeaderAttributeMasterUt;
	}

	public List<MmrBaseAttributeUomDetailsUt> getMmrBaseAttributeUomDetailsUts() {
		return this.mmrBaseAttributeUomDetailsUts;
	}

	public void setMmrBaseAttributeUomDetailsUts(List<MmrBaseAttributeUomDetailsUt> mmrBaseAttributeUomDetailsUts) {
		this.mmrBaseAttributeUomDetailsUts = mmrBaseAttributeUomDetailsUts;
		for(MmrBaseAttributeUomDetailsUt mmrBaseAttributeUomDetailsUt : this.mmrBaseAttributeUomDetailsUts) {
			mmrBaseAttributeUomDetailsUt.setMmrBaseAttributeMasterUt(this);
		}
	}	

	public MmrBaseAttributeUomDetailsUt addMmrBaseAttributeUomDetailsUt(MmrBaseAttributeUomDetailsUt mmrBaseAttributeUomDetailsUt) {
		getMmrBaseAttributeUomDetailsUts().add(mmrBaseAttributeUomDetailsUt);
		mmrBaseAttributeUomDetailsUt.setMmrBaseAttributeMasterUt(this);

		return mmrBaseAttributeUomDetailsUt;
	}

	public MmrBaseAttributeUomDetailsUt removeMmrBaseAttributeUomDetailsUt(MmrBaseAttributeUomDetailsUt mmrBaseAttributeUomDetailsUt) {
		getMmrBaseAttributeUomDetailsUts().remove(mmrBaseAttributeUomDetailsUt);
		mmrBaseAttributeUomDetailsUt.setMmrBaseAttributeMasterUt(null);

		return mmrBaseAttributeUomDetailsUt;
	}

	public String getDisplayNameUom1() {
		return displayNameUom1;
	}

	public void setDisplayNameUom1(String displayNameUom1) {
		this.displayNameUom1 = displayNameUom1;
	}

	public String getDisplayNameUom2() {
		return displayNameUom2;
	}

	public void setDisplayNameUom2(String displayNameUom2) {
		this.displayNameUom2 = displayNameUom2;
	}

	public String getPlaceHolderText() {
		return placeHolderText;
	}

	public void setPlaceHolderText(String placeHolderText) {
		this.placeHolderText = placeHolderText;
	}

	/*public BigDecimal getIsSearch() {
		return isSearch;
	}

	public void setIsSearch(BigDecimal isSearch) {
		this.isSearch = isSearch;
	}*/




	/*public List<MmrTestSheetDetailUt> getMmrTestSheetDetailUts() {
		return this.mmrTestSheetDetailUts;
	}

	public void setMmrTestSheetDetailUts(List<MmrTestSheetDetailUt> mmrTestSheetDetailUts) {
		this.mmrTestSheetDetailUts = mmrTestSheetDetailUts;
	}*/

	/*public MmrTestSheetDetailUt addMmrTestSheetDetailUt(MmrTestSheetDetailUt mmrTestSheetDetailUt) {
		getMmrTestSheetDetailUts().add(mmrTestSheetDetailUt);
		mmrTestSheetDetailUt.setMmrBaseAttributeMasterUt(this);

		return mmrTestSheetDetailUt;
	}

	public MmrTestSheetDetailUt removeMmrTestSheetDetailUt(MmrTestSheetDetailUt mmrTestSheetDetailUt) {
		getMmrTestSheetDetailUts().remove(mmrTestSheetDetailUt);
		mmrTestSheetDetailUt.setMmrBaseAttributeMasterUt(null);

		return mmrTestSheetDetailUt;
	}*/



}