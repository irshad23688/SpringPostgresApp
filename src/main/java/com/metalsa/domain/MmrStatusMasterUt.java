package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MMR_STATUS_MASTER_UT database table.
 * 
 */
@Entity
@Table(name="MMR_STATUS_MASTER_UT")
public class MmrStatusMasterUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=38)
	private long id;

	@Column(nullable=false, length=500)
	private String description;

	@Column(nullable=false, length=100)
	private String name;

	public MmrStatusMasterUt() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}