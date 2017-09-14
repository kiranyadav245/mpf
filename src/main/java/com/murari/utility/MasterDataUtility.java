package com.murari.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.murari.entity.QualityRange;
import com.murari.service.master.QualityRangeService;
import com.murari.vo.QualityRangeVo;

public class MasterDataUtility {

	@Autowired
	QualityRangeService qualityRangeService;

	public static List<QualityRangeVo> qualityRangeVos;
	public static Map<Integer , QualityRangeVo> qualityRangeVoMap = new HashMap<>();

	public List<QualityRangeVo> qualityRanges() {

		if (qualityRangeVos == null) {
			qualityRangeVos = new ArrayList<>();
			List<QualityRange> qualityRages = qualityRangeService.getQualityRanges();
			for (QualityRange qualityRange : qualityRages) {
				QualityRangeVo vo = new QualityRangeVo();
				vo.setRangeId(qualityRange.getRangeId());
				vo.setRangeName(qualityRange.getRangeName());
				vo.setRangeShortName(qualityRange.getRangeShortName());
				vo.setRangeFrom(qualityRange.getRangeFrom());
				vo.setRangeTo(qualityRange.getRangeTo());
				qualityRangeVos.add(vo);
				qualityRangeVoMap.put(vo.getRangeId(), vo);
			}
		}
		return qualityRangeVos;
	}

}
