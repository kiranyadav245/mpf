package com.murari.service.impl.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murari.dao.master.QualityRangeDAO;
import com.murari.entity.QualityRange;
import com.murari.service.master.QualityRangeService;

@Service
public class QualityRangeServiceImpl implements QualityRangeService {

	@Autowired
	private QualityRangeDAO qualityRangeDao;
	@Override
	public List<QualityRange> getQualityRanges() {
		return qualityRangeDao.getQualityRanges();
	}

	@Override
	public QualityRange getQualityRangeById(int rangeId) {
		QualityRange qualityRange = qualityRangeDao.getQualityRangeById(rangeId);
		return qualityRange;
	}

	@Override
	public synchronized boolean addQualityRange(QualityRange qualityRange) {
		
		qualityRangeDao.addQualityRange(qualityRange);
		return true;
	}

	@Override
	public void updateQualityRange(QualityRange qualityRange) {
		qualityRangeDao.updateQualityRange(qualityRange);
	}

	@Override
	public void deleteQualityRange(int rangeId) {
		qualityRangeDao.deleteQaulityRange(rangeId);
	}
}
