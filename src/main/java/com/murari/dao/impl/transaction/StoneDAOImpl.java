package com.murari.dao.impl.transaction;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.murari.dao.transaction.StoneDAO;
import com.murari.entity.StoneIn;
import com.murari.entity.StoneStock;
@Transactional
@Repository
public class StoneDAOImpl implements StoneDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StoneIn> getStoneInsById(int inStoneId) {
		String hql = "FROM StoneIn as dsi WHERE dsi.stoneInId = " + inStoneId;
		return (List<StoneIn>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public StoneIn getStoneInByIds(int inStoneId, int qualityRangeId) {
		String hql = "FROM StoneIn as dsi WHERE dsi.stoneInId = " + inStoneId + " AND dsi.qualityRange.rangeId = " + qualityRangeId;
		return (StoneIn) entityManager.createQuery(hql).getSingleResult();
	}

	@Override
	public StoneStock getStoneStockByRangeId(int qualityRangeId) {
//		String hql = "FROM StoneStock as ss WHERE  ss.qualityRange.rangeId = " + qualityRangeId;
//		return (StoneStock) entityManager.createQuery(hql).getSingleResult();
		return entityManager.find(StoneStock.class, qualityRangeId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StoneStock> getStockedStone() {
		String hql = "FROM StoneStock as ss WHERE  ss.qualityRange.rangeId in(select rangeId FROM QualityRange as qr where qr.validIndicator='Y')";
		return (List<StoneStock>) entityManager.createQuery(hql).getResultList();
//		return entityManager.find(StoneStock.class, qualityRangeId);
	}
	
	@Override
	public long getInStoneMaxId() {
		String hql = " FROM StoneIn sin where sin.id.stoneInId in (select max(dsin.id.stoneInId) from StoneIn dsin) ";
		@SuppressWarnings("unchecked")
		List<StoneIn> stoneIns =  (List<StoneIn>) entityManager.createQuery(hql).getResultList();
		if(stoneIns == null || stoneIns.size() == 0){
			return 0L;
		}else{
			return (long)stoneIns.get(0).getId().getStoneInId();
		}
	}

	@Override
	public void addInStone(StoneIn stoneIn) {
		entityManager.persist(stoneIn);
	}

	@Override
	public void addStoneStock(StoneStock stoneStock) {
		entityManager.persist(stoneStock);
		
	}

	@Override
	public void updateStoneStock(StoneStock stoneStock) {
		StoneStock stoneStockFromDB = getStoneStockByRangeId(stoneStock.getQualityRange().getRangeId());
		if(stoneStockFromDB != null){
			double totalQty = stoneStockFromDB.getStoneStock() + stoneStock.getStoneStock();
			stoneStockFromDB.setStoneStock(totalQty);
			stoneStockFromDB.setLastInQuantity(stoneStock.getLastInQuantity());
			stoneStockFromDB.setUpdatedDate(new java.sql.Date(new java.util.Date().getTime()));
			entityManager.flush();
		}
			
		
	}

	@Override
	public boolean stoneStockExists(int qualityRangeId) {
		StoneStock stoneStock = getStoneStockByRangeId(qualityRangeId);
		if(stoneStock == null)
			return false;
		else
			return true;
	}
	/*@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<QualityRange> getQualityRages() {
		String hql = "FROM QualityRange as qr ORDER BY qr.rangeId";
		return (List<QualityRange>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public QualityRange getQualityRangeById(int rangeId) {
		return entityManager.find(QualityRange.class, rangeId);
	}

	@Override
	public void addQualityRange(QualityRange qualityRange) {
		entityManager.persist(qualityRange);

	}

	@Override
	public void updateQualityRange(QualityRange qualityRange) {
		QualityRange range = getQualityRangeById(qualityRange.getRangeId());
		range.setRangeName(qualityRange.getRangeName());
		range.setRangeShortName(qualityRange.getRangeShortName());
		entityManager.flush();
	}

	@Override
	public void deleteQaulityRange(int rangeId) {
		entityManager.remove(getQualityRangeById(rangeId));
	}
*/
}
