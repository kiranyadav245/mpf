package com.murari.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.murari.vo.QualityRange;
import com.murari.vo.Stone;
import com.murari.vo.StoneIn;

@Controller
public class StoneController {
	@GetMapping("/stonein")
	public String stoneInForm(Model model){
		Stone stone = new Stone();
		List<StoneIn> stoneIns = new ArrayList<>();
		List<QualityRange> qualityRanges = qualityRanges();
		int i=1;
		for(QualityRange range : qualityRanges){
			StoneIn sIn = new StoneIn();
			sIn.setQualityRange(range);
			sIn.setStock(25*i++);
			stoneIns.add(sIn);
		}
		stone.setStoneIns(stoneIns);
		model.addAttribute("stone", stone);
		return "stone/stoneIn";
	}
	
	@PostMapping("/submitStone")
	public String submitStoneIn(@ModelAttribute Stone stone){
		return "stone/smsStoneIn";
	}
	
	@PostMapping("/smsStoneIn")
	public String smsStoneIn(@ModelAttribute Stone stone){
		return "stone/smsStoneIn";
	}
	
	
	public List<QualityRange> qualityRanges(){
		List<QualityRange> range = new ArrayList<>();
		range.add(new QualityRange("1","90-100"));
		range.add(new QualityRange("2","80-90"));
		range.add(new QualityRange("3","70-80"));
		range.add(new QualityRange("4","60-70"));
		range.add(new QualityRange("5","low"));
		return range;
	}
}
