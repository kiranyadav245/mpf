package com.murari.vo;

import javax.persistence.Column;

public class QualityRangeVo {
	private int rangeId;
	private String rangeName;
	private String rangeShortName;
	private int rangeFrom;
	private int rangeTo;
	private String range;
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
	public String getRange() {
		range = getRangeShortName() +"(" + getRangeFrom() +"-" + getRangeTo() + ")";
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	
}
