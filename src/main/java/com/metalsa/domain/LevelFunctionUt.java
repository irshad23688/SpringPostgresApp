package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the level_function_ut database table.
 * 
 */
@Entity
@Table(name="level_function_ut")
@NamedQuery(name="LevelFunctionUt.findAll", query="SELECT l FROM LevelFunctionUt l")
public class LevelFunctionUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="function_id")
	private Integer functionId;

	@Column(name="level_id")
	private Integer levelId;

	public LevelFunctionUt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(Integer functionId) {
		this.functionId = functionId;
	}

	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

}