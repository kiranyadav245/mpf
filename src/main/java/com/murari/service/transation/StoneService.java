package com.murari.service.transation;

import java.util.List;

import com.murari.entity.StoneIn;
import com.murari.entity.StoneStock;
import com.murari.vo.Stone;
import com.murari.vo.StoneStockVo;
public interface StoneService {
	List<StoneIn> getStoneInsById(int inStoneId);
	StoneIn getStoneInByIds(int inStoneId , int qualityRangeId);
	StoneStock getStoneStockByRangeId(int qualityRangeId);
	void addInStone(StoneIn stoneIn);
	void addStoneStock(StoneStock stoneStock);
	void updateStoneStock(StoneStock stoneStock);
	boolean stoneStockExists(int qualityRangeId);
	long saveDailyStoneIn(Stone stone);
	List<StoneStockVo> getStockedStones();
}
