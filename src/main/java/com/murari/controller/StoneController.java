package com.murari.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.murari.entity.QualityRange;
import com.murari.service.master.QualityRangeService;
import com.murari.vo.QualityRangeVo;
import com.murari.vo.Stone;
import com.murari.vo.StoneIn;

@Controller
public class StoneController {
	@Autowired
	QualityRangeService qualityRangeService;

	public static List<QualityRangeVo> qualityRangeVos;
	public static Map<Integer, QualityRangeVo> qualityRangeVoMap = new HashMap<>();

	@GetMapping("/stonein")
	public String stoneInForm(Model model) {
		Stone stone = new Stone();
		List<StoneIn> stoneIns = new ArrayList<>();
		List<QualityRangeVo> qualityRanges = qualityRanges();
		int i = 1;
		for (QualityRangeVo range : qualityRanges) {
			StoneIn sIn = new StoneIn();
			sIn.setQualityRange(range);
			sIn.setStock(25 * i++);
			stoneIns.add(sIn);
		}
		stone.setStoneIns(stoneIns);
		model.addAttribute("stone", stone);
		return "stone/stoneIn";
	}

	@PostMapping("/submitStone")
	public String submitStoneIn(@ModelAttribute Stone stone) {
		for (StoneIn s : stone.getStoneIns()) {
			s.setOpeningStock(s.getStock());
			s.setStock(s.getStock() * 100);
			s.setQualityRange(qualityRangeVoMap.get(s.getQualityRange().getRangeId()));
		}
		return "stone/smsStoneIn";
	}

	@PostMapping("/smsStoneIn")
	public String smsStoneIn(@ModelAttribute Stone stone) {
		return "stone/smsStoneIn";
	}

	public List<QualityRangeVo> qualityRanges() {
		if (qualityRangeVos == null) {
			qualityRangeVos = new ArrayList<>();
			List<QualityRange> qualityRages = qualityRangeService.getQualityRages();
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
