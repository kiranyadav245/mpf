package com.murari.vo;

import java.sql.Date;

public class StoneIn {
	private long id;
	private long inStone; // capture stone in at the date
	private long stock; //closing quantity
	private int unit;   //ton
	private Date inDate;
	private String comments; //get by who and which vehicle
	private QualityRange qualityRange;
	private long openingStock;
	
	//Kiran
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getInStone() {
		return inStone;
	}
	public void setInStone(long inStone) {
		this.inStone = inStone;
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
	public QualityRange getQualityRange() {
		return qualityRange;
	}
	public void setQualityRange(QualityRange qualityRange) {
		this.qualityRange = qualityRange;
	}
	public long getOpeningStock() {
		return openingStock;
	}
	public void setOpeningStock(long openingStock) {
		this.openingStock = openingStock;
	}
}
