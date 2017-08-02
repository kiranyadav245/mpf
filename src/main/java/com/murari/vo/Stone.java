package com.murari.vo;

import java.sql.Date;
import java.util.List;

public class Stone {
    private long id;
    private long openingQuantity;
    private long stock;
    private List<StoneIn> stoneIns;
    private List<ConsumedStone> consumedStones;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public List<StoneIn> getStoneIns() {
		return stoneIns;
	}
	public void setStoneIns(List<StoneIn> stoneIns) {
		this.stoneIns = stoneIns;
	}
	public List<ConsumedStone> getConsumedStones() {
		return consumedStones;
	}
	public void setConsumedStones(List<ConsumedStone> consumedStones) {
		this.consumedStones = consumedStones;
	}
    
    
}
