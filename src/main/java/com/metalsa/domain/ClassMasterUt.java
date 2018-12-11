package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the class_master_ut database table.
 * 
 */
@Entity
@Table(name="class_master_ut")
@NamedQuery(name="ClassMasterUt.findAll", query="SELECT c FROM ClassMasterUt c")
public class ClassMasterUt implements Serializable {
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

	@Column(name="modified_by")
	private String modifiedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="name",unique = true)
	private String name;

	private String status;

	//bi-directional many-to-one association to SubclassMasterUt
	@OneToMany(mappedBy="classMasterUt")
	private List<SubclassMasterUt> subclassMasterUts;

	public ClassMasterUt() {
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SubclassMasterUt> getSubclassMasterUts() {
		return this.subclassMasterUts;
	}

	public void setSubclassMasterUts(List<SubclassMasterUt> subclassMasterUts) {
		this.subclassMasterUts = subclassMasterUts;
	}

	public SubclassMasterUt addSubclassMasterUt(SubclassMasterUt subclassMasterUt) {
		getSubclassMasterUts().add(subclassMasterUt);
		subclassMasterUt.setClassMasterUt(this);

		return subclassMasterUt;
	}

	public SubclassMasterUt removeSubclassMasterUt(SubclassMasterUt subclassMasterUt) {
		getSubclassMasterUts().remove(subclassMasterUt);
		subclassMasterUt.setClassMasterUt(null);

		return subclassMasterUt;
	}

}