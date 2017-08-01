package com.murari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.murari.vo.Stone;

@Controller
public class StoneController {
	@GetMapping("/stonein")
	public String stoneInForm(Model model){
		model.addAttribute("stone", new Stone());
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
}
