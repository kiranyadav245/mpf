package com.murari.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STONE_STOCK")
public class StoneStock implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
//	@Column(name="ID")
//	private int stoneStockId;
	@Id
	@ManyToOne
	@JoinColumn(name="QUALITY_RANGE_ID")
	private QualityRange qualityRange;
	@Column(name="STONE_QTY")
	private double stoneStock;
	@Column(name="LAST_IN_STONE")
	private double lastInQuantity;
	@Column(name="LAST_CNSMED_STONE")
	private double lastConsumedQuantity;
	@Column(name="LAST_UPDATED_USER")
	private String userId;
	@Column(name="LAST_UPDATED_DATE")
	private Date updatedDate;
	/*public int getStoneStockId() {
		return stoneStockId;
	}
	public void setStoneStockId(int stoneStockId) {
		this.stoneStockId = stoneStockId;
	}*/
	public QualityRange getQualityRange() {
		return qualityRange;
	}
	public void setQualityRange(QualityRange qualityRange) {
		this.qualityRange = qualityRange;
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
}
