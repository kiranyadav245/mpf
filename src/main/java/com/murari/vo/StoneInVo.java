package com.murari.vo;

import java.sql.Date;

import javax.persistence.Column;

public class StoneInVo {
	private long stoneInId;
	private long inQuantity; // capture stone in at the date
	private long stock; //closing quantity
	private Date inDate;
	private String comments; //get by who and which vehicle
	private QualityRangeVo qualityRange;
	private long openingStock;
	public long getStoneInId() {
		return stoneInId;
	}
	public void setStoneInId(long stoneInId) {
		this.stoneInId = stoneInId;
	}
	public long getInQuantity() {
		return inQuantity;
	}
	public void setInQuantity(long inQuantity) {
		this.inQuantity = inQuantity;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public QualityRangeVo getQualityRange() {
		return qualityRange;
	}
	public void setQualityRange(QualityRangeVo qualityRange) {
		this.qualityRange = qualityRange;
	}
	public long getOpeningStock() {
		return openingStock;
	}
	public void setOpeningStock(long openingStock) {
		this.openingStock = openingStock;
	}
	
}
