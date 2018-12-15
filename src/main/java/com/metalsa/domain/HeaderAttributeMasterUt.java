package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the header_attribute_master_ut database table.
 * 
 */
@Entity
@Table(name="header_attribute_master_ut")
@NamedQuery(name="HeaderAttributeMasterUt.findAll", query="SELECT h FROM HeaderAttributeMasterUt h")
public class HeaderAttributeMasterUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="created_by")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_on")
	private Date createdOn;

	private String description;
	
	private String status;

	@Column(name="istableheader_flag")
	private String istableheaderFlag;

	@Column(name="modified_by")
	private String modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String name;

	public HeaderAttributeMasterUt() {
	}

	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIstableheaderFlag() {
		return this.istableheaderFlag;
	}

	public void setIstableheaderFlag(String istableheaderFlag) {
		this.istableheaderFlag = istableheaderFlag;
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}