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
import com.murari.service.transation.StoneService;
import com.murari.vo.QualityRangeVo;
import com.murari.vo.Stone;
import com.murari.vo.StoneInVo;
import com.murari.vo.StoneStockVo;

@Controller
public class StoneController {
	@Autowired
	QualityRangeService qualityRangeService;
	
	@Autowired
	StoneService stoneService;

	public static List<QualityRangeVo> qualityRangeVos;
	public static Map<Integer, QualityRangeVo> qualityRangeVoMap = new HashMap<>();

	@GetMapping("/stonein")
	public String stoneInForm(Model model) {
		Stone stone = new Stone();
		List<StoneInVo> stoneIns = new ArrayList<>();
		List<QualityRangeVo> qualityRanges = qualityRanges();
		List<StoneStockVo> stockedStones = stoneService.getStockedStones();
		for (StoneStockVo ssVo : stockedStones) {
			StoneInVo sIn = new StoneInVo();
			sIn.setQualityRange(ssVo.getQualityRangeVo());
			sIn.setStock(ssVo.getStoneStock());
			stoneIns.add(sIn);
		}
		stone.setStoneIns(stoneIns);
		model.addAttribute("stone", stone);
		return "stone/stoneIn";
	}

	@PostMapping("/submitStone")
	public String submitStoneIn(@ModelAttribute Stone stone) {
		List<StoneStockVo> stockedStones = stoneService.getStockedStones();
		for (StoneInVo s : stone.getStoneIns()) {
			s.setOpeningStock(s.getStock());
			s.setQualityRange(qualityRangeVoMap.get(s.getQualityRange().getRangeId()));
			for(StoneStockVo svo: stockedStones){
				if(svo.getQualityRangeVo().getRangeId() == s.getQualityRange().getRangeId()){
					s.setStock(svo.getStoneStock() + s.getInQuantity());
					break;
				}
			}
		}
		long inStoneId = stoneService.saveDailyStoneIn(stone);
		stone.setInStoneId(inStoneId);
		return "stone/smsStoneIn";
	}

	@PostMapping("/smsStoneIn")
	public String smsStoneIn(@ModelAttribute Stone stone) {
		System.out.println("jdfjkdsfjk" + stone);
		
		return "redirect:/home";
	}

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
