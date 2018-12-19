package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


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

	@Column(name="DISPLAY_NAME", nullable=false, length=100)
	private String displayName;

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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DATA_TYPE_ID", nullable=false)
	private MmrDataTypeMasterUt mmrDataTypeMasterUt;

	//bi-directional many-to-one association to MmrHeaderAttributeMasterUt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HEADER_ATTRIBUTE_ID", nullable=false)
	private MmrHeaderAttributeMasterUt mmrHeaderAttributeMasterUt;

	//bi-directional many-to-one association to MmrBaseAttributeTableDataTypeUt
	@OneToMany(mappedBy="mmrBaseAttributeMasterUt")
	private List<MmrBaseAttributeTableDataTypeUt> mmrBaseAttributeTableDataTypeUts;

	//bi-directional many-to-one association to MmrBaseAttributeUomDetailsUt
	@OneToMany(mappedBy="mmrBaseAttributeMasterUt")
	private List<MmrBaseAttributeUomDetailsUt> mmrBaseAttributeUomDetailsUts;

	//bi-directional many-to-one association to MmrTestSheetDetailUt
	@OneToMany(mappedBy="mmrBaseAttributeMasterUt")
	private List<MmrTestSheetDetailUt> mmrTestSheetDetailUts;

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

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public MmrHeaderAttributeMasterUt getMmrHeaderAttributeMasterUt() {
		return this.mmrHeaderAttributeMasterUt;
	}

	public void setMmrHeaderAttributeMasterUt(MmrHeaderAttributeMasterUt mmrHeaderAttributeMasterUt) {
		this.mmrHeaderAttributeMasterUt = mmrHeaderAttributeMasterUt;
	}

	public List<MmrBaseAttributeTableDataTypeUt> getMmrBaseAttributeTableDataTypeUts() {
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
	}

	public List<MmrBaseAttributeUomDetailsUt> getMmrBaseAttributeUomDetailsUts() {
		return this.mmrBaseAttributeUomDetailsUts;
	}

	public void setMmrBaseAttributeUomDetailsUts(List<MmrBaseAttributeUomDetailsUt> mmrBaseAttributeUomDetailsUts) {
		this.mmrBaseAttributeUomDetailsUts = mmrBaseAttributeUomDetailsUts;
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

	public List<MmrTestSheetDetailUt> getMmrTestSheetDetailUts() {
		return this.mmrTestSheetDetailUts;
	}

	public void setMmrTestSheetDetailUts(List<MmrTestSheetDetailUt> mmrTestSheetDetailUts) {
		this.mmrTestSheetDetailUts = mmrTestSheetDetailUts;
	}

	public MmrTestSheetDetailUt addMmrTestSheetDetailUt(MmrTestSheetDetailUt mmrTestSheetDetailUt) {
		getMmrTestSheetDetailUts().add(mmrTestSheetDetailUt);
		mmrTestSheetDetailUt.setMmrBaseAttributeMasterUt(this);

		return mmrTestSheetDetailUt;
	}

	public MmrTestSheetDetailUt removeMmrTestSheetDetailUt(MmrTestSheetDetailUt mmrTestSheetDetailUt) {
		getMmrTestSheetDetailUts().remove(mmrTestSheetDetailUt);
		mmrTestSheetDetailUt.setMmrBaseAttributeMasterUt(null);

		return mmrTestSheetDetailUt;
	}

}