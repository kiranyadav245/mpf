package com.murari.service.impl.transaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murari.dao.transaction.StoneDAO;
import com.murari.entity.QualityRange;
import com.murari.entity.StoneIn;
import com.murari.entity.StoneInKey;
import com.murari.entity.StoneStock;
import com.murari.service.transation.StoneService;
import com.murari.vo.QualityRangeVo;
import com.murari.vo.Stone;
import com.murari.vo.StoneInVo;
import com.murari.vo.StoneStockVo;

@Service
public class StoneServiceImpl implements StoneService {
	@Autowired
	private StoneDAO stoneDao;

	@Override
	public List<StoneIn> getStoneInsById(int inStoneId) {
		List<StoneIn> stoneInById = stoneDao.getStoneInsById(inStoneId);
		return stoneInById;
	}

	@Override
	public StoneIn getStoneInByIds(int inStoneId, int qualityRangeId) {
		StoneIn stoneIn = stoneDao.getStoneInByIds(inStoneId, qualityRangeId);
		return stoneIn;
	}

	@Override
	public StoneStock getStoneStockByRangeId(int qualityRangeId) {
		StoneStock stoneStock = null;
		try{
			stoneStock = stoneDao.getStoneStockByRangeId(qualityRangeId);
		}catch (Exception e) {
			stoneStock = null;
		}
		return stoneStock;
	}

	@Override
	public void addInStone(StoneIn stoneIn) {
		stoneDao.addInStone(stoneIn);

	}

	@Override
	public void addStoneStock(StoneStock stoneStock) {
		stoneDao.addStoneStock(stoneStock);
	}

	@Override
	public void updateStoneStock(StoneStock stoneStock) {
		stoneDao.updateStoneStock(stoneStock);
	}

	@Override
	public boolean stoneStockExists(int qualityRangeId) {
		return stoneDao.stoneStockExists(qualityRangeId);
	}

	@Override
	public long saveDailyStoneIn(Stone stone) {
		long inStoneId = 0;
		if (stone != null && stone.getStoneIns() != null && !stone.getStoneIns().isEmpty()) {
			inStoneId = stoneDao.getInStoneMaxId() +1;
			for (StoneInVo stoneInVo : stone.getStoneIns()) {
				if (stoneInVo.getInQuantity() > 0) {
					UpdateStone(inStoneId, stoneInVo);
				}

			}
			
		}
		return inStoneId;
	}

	private void UpdateStone(long inStoneId, StoneInVo stoneInVo) {
		StoneIn sIn = new StoneIn();
		StoneInKey key = new StoneInKey();
		key.setStoneInId((int) inStoneId);
		key.setQualityRangeId(stoneInVo.getQualityRange().getRangeId());
		sIn.setId(key);
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		sIn.setInDate(sqlDate);
		sIn.setComments(stoneInVo.getComments());
		sIn.setInQuantity(stoneInVo.getInQuantity());
		QualityRangeVo qualityRangeVo = stoneInVo.getQualityRange();
		QualityRange qr = new QualityRange();
		qr.setRangeFrom(qualityRangeVo.getRangeFrom());
		qr.setRangeId(qualityRangeVo.getRangeId());
		qr.setRangeName(qualityRangeVo.getRangeName());
		qr.setRangeShortName(qualityRangeVo.getRangeShortName());
		qr.setRangeTo(qualityRangeVo.getRangeTo());
		qr.setValidIndicator(qualityRangeVo.getValidIndicator());
//		sIn.setQuality(qr);
		sIn.setUserId(1);
		addInStone(sIn);
		sIn = null;
		StoneStock stoneStock = getStoneStockByRangeId(qualityRangeVo.getRangeId());
		if(stoneStock != null){ 
			stoneStock.setStoneStock(stoneStock.getStoneStock() + stoneInVo.getInQuantity());
			stoneStock.setLastInQuantity(stoneInVo.getInQuantity());
			stoneStock.setUserId("1");
			stoneStock.setUpdatedDate(new java.sql.Date(new java.util.Date().getTime()));
//			updateStoneStock(stoneStock);
		}else{
			stoneStock = new StoneStock();
			stoneStock.setQualityRange(qr);
			stoneStock.setLastInQuantity(stoneInVo.getInQuantity());
			stoneStock.setStoneStock(stoneInVo.getInQuantity());
			java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
//			stoneStock.setStoneStockId(1);
			stoneStock.setUserId("1");
			stoneStock.setUpdatedDate(now);
			addStoneStock(stoneStock);
		}
		stoneStock = null;
	}
	
	@Override
	public List<StoneStockVo> getStockedStones(){
		List<StoneStock> stockedStone = stoneDao.getStockedStone();
		List<StoneStockVo> vos = new ArrayList<>();
		for(StoneStock s: stockedStone){
			StoneStockVo vo = new StoneStockVo();
			 QualityRangeVo qVo = new QualityRangeVo();
			 QualityRange range = s.getQualityRange();
			 qVo.setRangeId(range.getRangeId());
			 qVo.setRange(range.getRangeName());
			 qVo.setRangeFrom(range.getRangeFrom());
			 qVo.setRangeTo(range.getRangeTo());
			 qVo.setRangeShortName(range.getRangeShortName());
			 vo.setQualityRangeVo(qVo);
			 vo.setStoneStock(s.getStoneStock());
			 vo.setLastInQuantity(s.getLastConsumedQuantity());
			 vo.setLastInQuantity(s.getLastInQuantity());
			 vo.setUpdatedDate(s.getUpdatedDate());
			 vo.setUserId(s.getUserId());
			 vos.add(vo);
		}
		
		return vos;
	}

}
