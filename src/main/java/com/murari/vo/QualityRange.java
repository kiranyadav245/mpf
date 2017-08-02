package com.murari.vo;

public class QualityRange {
	public QualityRange(){
		
	}
	public QualityRange(String rangeId, String range) {
		super();
		this.rangeId = rangeId;
		this.range = range;
	}
	
	private String rangeId;
	private String range;
	public String getRangeId() {
		return rangeId;
	}
	public void setRangeId(String rangeId) {
		this.rangeId = rangeId;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	
}
