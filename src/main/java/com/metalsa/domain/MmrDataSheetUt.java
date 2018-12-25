package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the MMR_DATA_SHEET_UT database table.
 * 
 */
@Entity
@Table(name="MMR_DATA_SHEET_UT")
public class MmrDataSheetUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(name="APPROVED_BY", nullable=false, precision=38)
	private BigDecimal approvedBy;

	@Column(name="APPROVED_ON", nullable=false)
	private Timestamp approvedOn;

	@Column(name="CLASS_ID", nullable=false, precision=38)
	private BigDecimal classId;

	@Column(name="CREATED_BY", nullable=false, precision=38)
	private BigDecimal createdBy;

	@Column(name="CREATED_ON", nullable=false)
	private Timestamp createdOn;

	@Column(name="DATA_SHEET_NAME", nullable=false, length=50)
	private String dataSheetName;

	@Column(nullable=false, length=5)
	private String issubmitted;

	@Column(name="MODIFIED_BY", precision=38)
	private BigDecimal modifiedBy;

	@Column(name="MODIFIED_ON")
	private Timestamp modifiedOn;

	@Column(nullable=false, precision=38)
	private BigDecimal revision;

	@Column(nullable=false, precision=38)
	private BigDecimal status;

	@Column(name="SUBCLASS_ID", nullable=false, precision=38)
	private BigDecimal subclassId;

	@Column(name="TEST_SHEET_ID", nullable=false, precision=38)
	private BigDecimal testSheetId;

	//bi-directional many-to-one association to MmrDataSheetDetailUt
	@OneToMany(mappedBy="mmrDataSheetUt")
	private List<MmrDataSheetDetailUt> mmrDataSheetDetailUts;

	public MmrDataSheetUt() {
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

	public BigDecimal getClassId() {
		return this.classId;
	}

	public void setClassId(BigDecimal classId) {
		this.classId = classId;
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

	public String getDataSheetName() {
		return this.dataSheetName;
	}

	public void setDataSheetName(String dataSheetName) {
		this.dataSheetName = dataSheetName;
	}

	public String getIssubmitted() {
		return this.issubmitted;
	}

	public void setIssubmitted(String issubmitted) {
		this.issubmitted = issubmitted;
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

	public BigDecimal getRevision() {
		return this.revision;
	}

	public void setRevision(BigDecimal revision) {
		this.revision = revision;
	}

	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public BigDecimal getSubclassId() {
		return this.subclassId;
	}

	public void setSubclassId(BigDecimal subclassId) {
		this.subclassId = subclassId;
	}

	public BigDecimal getTestSheetId() {
		return this.testSheetId;
	}

	public void setTestSheetId(BigDecimal testSheetId) {
		this.testSheetId = testSheetId;
	}

	public List<MmrDataSheetDetailUt> getMmrDataSheetDetailUts() {
		return this.mmrDataSheetDetailUts;
	}

	public void setMmrDataSheetDetailUts(List<MmrDataSheetDetailUt> mmrDataSheetDetailUts) {
		this.mmrDataSheetDetailUts = mmrDataSheetDetailUts;
	}

	public MmrDataSheetDetailUt addMmrDataSheetDetailUt(MmrDataSheetDetailUt mmrDataSheetDetailUt) {
		getMmrDataSheetDetailUts().add(mmrDataSheetDetailUt);
		mmrDataSheetDetailUt.setMmrDataSheetUt(this);

		return mmrDataSheetDetailUt;
	}

	public MmrDataSheetDetailUt removeMmrDataSheetDetailUt(MmrDataSheetDetailUt mmrDataSheetDetailUt) {
		getMmrDataSheetDetailUts().remove(mmrDataSheetDetailUt);
		mmrDataSheetDetailUt.setMmrDataSheetUt(null);

		return mmrDataSheetDetailUt;
	}

}