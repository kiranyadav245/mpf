package com.murari.vo;

import java.sql.Date;

public class ConsumedStone {
	private long id;
	private Date consumeDate;
    private long consumedStone; //how much stone consumed per day
    private String operator;	//machine operator
    private QualityRangeVo qualityRange; // stone quality
	private long stock; //closing quantity
	private int unit; //unit of stone ton/etc
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getConsumeDate() {
		return consumeDate;
	}
	public void setConsumeDate(Date consumeDate) {
		this.consumeDate = consumeDate;
	}
	public long getConsumedStone() {
		return consumedStone;
	}
	public void setConsumedStone(long consumedStone) {
		this.consumedStone = consumedStone;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public QualityRangeVo getQualityRange() {
		return qualityRange;
	}
	public void setQualityRange(QualityRangeVo qualityRange) {
		this.qualityRange = qualityRange;
	}
	
	
}
