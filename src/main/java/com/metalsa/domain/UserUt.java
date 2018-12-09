package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_ut database table.
 * 
 */
@Entity
@Table(name="user_ut")
@NamedQuery(name="UserUt.findAll", query="SELECT u FROM UserUt u")
public class UserUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="contact_number")
	private String contactNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="level_function_id")
	private Integer levelFunctionId;

	private String name;

	@Column(name="region_id")
	private Integer regionId;

	private String status;

	@Temporal(TemporalType.DATE)
	private Date timezone;

	private String username;

	public UserUt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Integer getLevelFunctionId() {
		return this.levelFunctionId;
	}

	public void setLevelFunctionId(Integer levelFunctionId) {
		this.levelFunctionId = levelFunctionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTimezone() {
		return this.timezone;
	}

	public void setTimezone(Date timezone) {
		this.timezone = timezone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}