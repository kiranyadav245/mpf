package com.murari.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QUALITY_RANGE")
public class QualityRange implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Id
	@Column(name="RANGE_ID")
	private int rangeId;
	@Column(name="RANGE_NM")
	private String rangeName;
	@Column(name="RANGE_SHORT_NM")
	private String rangeShortName;
	@Column(name="RANGE_FROM")
	private int rangeFrom;
	@Column(name="RANGE_TO")
	private int rangeTo;
	@Column(name="VALID_IND")
	private String validIndicator;
	public int getRangeId() {
		return rangeId;
	}
	public void setRangeId(int rangeId) {
		this.rangeId = rangeId;
	}
	public String getRangeName() {
		return rangeName;
	}
	public void setRangeName(String rangeName) {
		this.rangeName = rangeName;
	}
	public String getRangeShortName() {
		return rangeShortName;
	}
	public void setRangeShortName(String rangeShortName) {
		this.rangeShortName = rangeShortName;
	}
	public int getRangeFrom() {
		return rangeFrom;
	}
	public void setRangeFrom(int rangeFrom) {
		this.rangeFrom = rangeFrom;
	}
	public int getRangeTo() {
		return rangeTo;
	}
	public void setRangeTo(int rangeTo) {
		this.rangeTo = rangeTo;
	}
	public String getValidIndicator() {
		return validIndicator;
	}
	public void setValidIndicator(String validIndicator) {
		this.validIndicator = validIndicator;
	}
	
}
