package com.murari.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StoneInKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="DSI_ID")
	private int stoneInId;
	@Column(name="QUALITY_RANGE_ID")
	private int qualityRangeId;
	public int getStoneInId() {
		return stoneInId;
	}
	public void setStoneInId(int stoneInId) {
		this.stoneInId = stoneInId;
	}
	public int getQualityRangeId() {
		return qualityRangeId;
	}
	public void setQualityRangeId(int qualityRangeId) {
		this.qualityRangeId = qualityRangeId;
	}
}
