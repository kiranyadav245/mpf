package com.murari.dao.impl.master;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.murari.dao.master.QualityRangeDAO;
import com.murari.entity.QualityRange;
@Transactional
@Repository
public class QualityRangeDAOImpl implements QualityRangeDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<QualityRange> getQualityRanges() {
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

}
