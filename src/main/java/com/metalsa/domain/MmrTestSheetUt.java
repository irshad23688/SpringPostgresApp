package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the MMR_TEST_SHEET_UT database table.
 * 
 */
@Entity
@Table(name="MMR_TEST_SHEET_UT")
public class MmrTestSheetUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="APPROVED_BY", nullable=false, precision=38)
	private BigDecimal approvedBy;

	@Column(name="APPROVED_ON", nullable=false)
	private Timestamp approvedOn;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", nullable=false)
	private Timestamp createdOn;

	@Column(nullable=false, length=500)
	private String description;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	@Column(nullable=false, length=100)
	private String name;

	@Column(nullable=false, precision=38)
	private BigDecimal status;

	//bi-directional many-to-one association to MmrTestSheetDetailUt
	@OneToMany(mappedBy="mmrTestSheetUt")
	private List<MmrTestSheetDetailUt> mmrTestSheetDetailUts;

	//bi-directional many-to-one association to MmrClassMasterUt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLASS_ID", nullable=false)
	private MmrClassMasterUt mmrClassMasterUt;

	//bi-directional many-to-one association to MmrSubclassMasterUt
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SUBCLASS_ID", nullable=false)
	private MmrSubclassMasterUt mmrSubclassMasterUt;

	public MmrTestSheetUt() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(BigDecimal approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Timestamp getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Timestamp approvedOn) {
		this.approvedOn = approvedOn;
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

	public List<MmrTestSheetDetailUt> getMmrTestSheetDetailUts() {
		return this.mmrTestSheetDetailUts;
	}

	public void setMmrTestSheetDetailUts(List<MmrTestSheetDetailUt> mmrTestSheetDetailUts) {
		this.mmrTestSheetDetailUts = mmrTestSheetDetailUts;
	}

	public MmrTestSheetDetailUt addMmrTestSheetDetailUt(MmrTestSheetDetailUt mmrTestSheetDetailUt) {
		getMmrTestSheetDetailUts().add(mmrTestSheetDetailUt);
		mmrTestSheetDetailUt.setMmrTestSheetUt(this);

		return mmrTestSheetDetailUt;
	}

	public MmrTestSheetDetailUt removeMmrTestSheetDetailUt(MmrTestSheetDetailUt mmrTestSheetDetailUt) {
		getMmrTestSheetDetailUts().remove(mmrTestSheetDetailUt);
		mmrTestSheetDetailUt.setMmrTestSheetUt(null);

		return mmrTestSheetDetailUt;
	}

	public MmrClassMasterUt getMmrClassMasterUt() {
		return this.mmrClassMasterUt;
	}

	public void setMmrClassMasterUt(MmrClassMasterUt mmrClassMasterUt) {
		this.mmrClassMasterUt = mmrClassMasterUt;
	}

	public MmrSubclassMasterUt getMmrSubclassMasterUt() {
		return this.mmrSubclassMasterUt;
	}

	public void setMmrSubclassMasterUt(MmrSubclassMasterUt mmrSubclassMasterUt) {
		this.mmrSubclassMasterUt = mmrSubclassMasterUt;
	}

}