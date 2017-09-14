package com.murari.vo;

import java.util.List;

public class Stone {
    private long inStoneId;
    private long consumedStoneId;
    private long openingQuantity;
    private long stock;
    private List<StoneInVo> stoneIns;
    private List<ConsumedStone> consumedStones;
	
	public long getInStoneId() {
		return inStoneId;
	}
	public void setInStoneId(long inStoneId) {
		this.inStoneId = inStoneId;
	}
	public long getConsumedStoneId() {
		return consumedStoneId;
	}
	public void setConsumedStoneId(long consumedStoneId) {
		this.consumedStoneId = consumedStoneId;
	}
	public long getOpeningQuantity() {
		return openingQuantity;
	}
	public void setOpeningQuantity(long openingQuantity) {
		this.openingQuantity = openingQuantity;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public List<StoneInVo> getStoneIns() {
		return stoneIns;
	}
	public void setStoneIns(List<StoneInVo> stoneIns) {
		this.stoneIns = stoneIns;
	}
	public List<ConsumedStone> getConsumedStones() {
		return consumedStones;
	}
	public void setConsumedStones(List<ConsumedStone> consumedStones) {
		this.consumedStones = consumedStones;
	}
    
    
}
