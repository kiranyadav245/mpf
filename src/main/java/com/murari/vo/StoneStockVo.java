package com.murari.vo;

import java.io.Serializable;
import java.sql.Date;

public class StoneStockVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private QualityRangeVo qualityRangeVo;
	private double stoneStock;
	private double lastInQuantity;
	private double lastConsumedQuantity;
	private String userId;
	private Date updatedDate;
	public QualityRangeVo getQualityRangeVo() {
		return qualityRangeVo;
	}
	public void setQualityRangeVo(QualityRangeVo qualityRangeVo) {
		this.qualityRangeVo = qualityRangeVo;
	}
	public double getStoneStock() {
		return stoneStock;
	}
	public void setStoneStock(double stoneStock) {
		this.stoneStock = stoneStock;
	}
	public double getLastInQuantity() {
		return lastInQuantity;
	}
	public void setLastInQuantity(double lastInQuantity) {
		this.lastInQuantity = lastInQuantity;
	}
	public double getLastConsumedQuantity() {
		return lastConsumedQuantity;
	}
	public void setLastConsumedQuantity(double lastConsumedQuantity) {
		this.lastConsumedQuantity = lastConsumedQuantity;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "StoneStockVo [qualityRangeVo=" + qualityRangeVo + ", stoneStock=" + stoneStock + ", lastInQuantity="
				+ lastInQuantity + ", lastConsumedQuantity=" + lastConsumedQuantity + ", userId=" + userId
				+ ", updatedDate=" + updatedDate + "]";
	}
	
	

}
