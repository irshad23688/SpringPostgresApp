package com.metalsa.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the test_sheet_detail_ut database table.
 * 
 */
@Entity
@Table(name="test_sheet_detail_ut")
@NamedQuery(name="TestSheetDetailUt.findAll", query="SELECT t FROM TestSheetDetailUt t")
public class TestSheetDetailUt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="base_attribute_id")
	private Integer baseAttributeId;

	@Column(name="base_attribute_sequence_no")
	private Integer baseAttributeSequenceNo;

	@Column(name="header_attribute_id")
	private Integer headerAttributeId;

	@Column(name="test_sheet_id")
	private Integer testSheetId;

	public TestSheetDetailUt() {
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

	public Integer getBaseAttributeSequenceNo() {
		return this.baseAttributeSequenceNo;
	}

	public void setBaseAttributeSequenceNo(Integer baseAttributeSequenceNo) {
		this.baseAttributeSequenceNo = baseAttributeSequenceNo;
	}

	public Integer getHeaderAttributeId() {
		return this.headerAttributeId;
	}

	public void setHeaderAttributeId(Integer headerAttributeId) {
		this.headerAttributeId = headerAttributeId;
	}

	public Integer getTestSheetId() {
		return this.testSheetId;
	}

	public void setTestSheetId(Integer testSheetId) {
		this.testSheetId = testSheetId;
	}

}