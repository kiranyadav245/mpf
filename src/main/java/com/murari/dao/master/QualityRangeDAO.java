package com.murari.dao.master;

import java.util.List;
import com.murari.entity.QualityRange;
public interface QualityRangeDAO {
	List<QualityRange> getQualityRages();
	QualityRange getQualityRangeById(int rangeId);
	void addQualityRange(QualityRange qualityRange);
	void updateQualityRange(QualityRange qualityRange);
	void deleteQaulityRange(int rangeId);
//	boolean articleExists(String title, String category);
}
