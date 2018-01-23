package com.murari.dao.transaction;

import java.util.List;
import com.murari.entity.QualityRange;
import com.murari.entity.StoneIn;
import com.murari.entity.StoneStock;
public interface StoneDAO {
	List<StoneIn> getStoneInsById(int inStoneId);
	StoneIn getStoneInByIds(int inStoneId , int qualityRangeId);
	StoneStock getStoneStockByRangeId(int qualityRangeId);
	void addInStone(StoneIn stoneIn);
	void addStoneStock(StoneStock stoneStock);
	void updateStoneStock(StoneStock stoneStock);
	boolean stoneStockExists(int qualityRangeId);
	public long getInStoneMaxId();
	public List<StoneStock> getStockedStone();
}
