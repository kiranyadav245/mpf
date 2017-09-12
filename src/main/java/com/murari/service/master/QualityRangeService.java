package com.murari.service.master;

import java.util.List;
import com.murari.entity.QualityRange;
public interface QualityRangeService {
	List<QualityRange> getQualityRages();
	QualityRange getQualityRangeById(int rangeId);
	boolean addQualityRange(QualityRange qualityRange);
	void updateQualityRange(QualityRange qualityRange);
	void deleteQualityRange(int rangeId);
//	boolean articleExists(String title, String category);
}
