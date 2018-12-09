package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the base_attribute_table_data_type_ut database table.
 * 
 */
@Entity
@Table(name="base_attribute_table_data_type_ut")
@NamedQuery(name="BaseAttributeTableDataTypeUt.findAll", query="SELECT b FROM BaseAttributeTableDataTypeUt b")
public class BaseAttributeTableDataTypeUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="base_attribute_id")
	private Integer baseAttributeId;

	@Column(name="parameter_base_attribute_id")
	private Integer parameterBaseAttributeId;

	public BaseAttributeTableDataTypeUt() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBaseAttributeId() {
		return this.baseAttributeId;
	}

	public void setBaseAttributeId(Integer baseAttributeId) {
		this.baseAttributeId = baseAttributeId;
	}

	public Integer getParameterBaseAttributeId() {
		return this.parameterBaseAttributeId;
	}

	public void setParameterBaseAttributeId(Integer parameterBaseAttributeId) {
		this.parameterBaseAttributeId = parameterBaseAttributeId;
	}

}