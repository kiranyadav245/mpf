package com.murari.vo;

import java.sql.Date;

public class StoneInVo {
	private long stoneInId;
	private double inQuantity; // capture stone in at the date
	private double stock; //closing quantity
	private Date inDate;
	private String comments; //get by who and which vehicle
	private QualityRangeVo qualityRange;
	private double openingStock;
	public long getStoneInId() {
		return stoneInId;
	}
	public void setStoneInId(long stoneInId) {
		this.stoneInId = stoneInId;
	}
	public double getInQuantity() {
		return inQuantity;
	}
	public void setInQuantity(double inQuantity) {
		this.inQuantity = inQuantity;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
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
	public double getOpeningStock() {
		return openingStock;
	}
	public void setOpeningStock(double openingStock) {
		this.openingStock = openingStock;
	}
	@Override
	public String toString() {
		return "StoneInVo [stoneInId=" + stoneInId + ", inQuantity=" + inQuantity + ", stock=" + stock + ", inDate="
				+ inDate + ", comments=" + comments + ", qualityRange=" + qualityRange + ", openingStock="
				+ openingStock + "]";
	}
	
	
}
