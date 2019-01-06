package com.metalsa.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public abstract class MetalsaAbstractEntityModel {

	protected Long id;
	protected BigDecimal createdBy;
	protected Timestamp createdOn;
	protected BigDecimal modifiedBy;
	protected Timestamp modifiedOn;
	protected BigDecimal status;
	
	 
	public BigDecimal getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public BigDecimal getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(BigDecimal modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public BigDecimal getStatus() {
		return status;
	}
	public void setStatus(BigDecimal status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
}
