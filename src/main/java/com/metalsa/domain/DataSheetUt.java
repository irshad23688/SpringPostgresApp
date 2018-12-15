package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the data_sheet_ut database table.
 * 
 */
@Entity
@Table(name="data_sheet_ut")
@NamedQuery(name="DataSheetUt.findAll", query="SELECT d FROM DataSheetUt d")
public class DataSheetUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="approved_by")
	private String approvedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="approved_on")
	private Date approvedOn;

	@Column(name="class_id")
	private Integer classId;
	
	
	@Column(name="revision_id")
	private Integer revisionId;
	
	@Column(name="region_id")
	private Integer regionId;

	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="metalsa_designation")
	private String metalsaDesignation;

	@Temporal(TemporalType.DATE)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="data_sheet_name")
	private String dataSheetName;

	private String issubmitted;

	@Column(name="modified_by")
	private String modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String status;

	@Column(name="subclass_id")
	private Integer subclassId;

	@Column(name="test_sheet_id")
	private Integer testSheetId;

	public DataSheetUt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
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

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSubclassId() {
		return this.subclassId;
	}

	public void setSubclassId(Integer subclassId) {
		this.subclassId = subclassId;
	}

	public Integer getTestSheetId() {
		return this.testSheetId;
	}

	public void setTestSheetId(Integer testSheetId) {
		this.testSheetId = testSheetId;
	}

}