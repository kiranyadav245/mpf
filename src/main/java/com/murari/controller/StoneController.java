package com.murari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.murari.vo.Stone;

@Controller
public class StoneController {
	@GetMapping("/isd")
	public String isdForm(Model model){
		model.addAttribute("stone", new Stone());
		return "sd/isd";
	}
	
	@PostMapping("/isd")
	public String isdSubmit(@ModelAttribute Stone stone){
		return "sd/sdlist";
	}
}
