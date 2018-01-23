package com.murari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.murari.service.transation.StoneService;
import com.murari.vo.StoneStockVo;

@Controller
public class DefaultController {
	
	@Autowired
	StoneService stoneService;
	@GetMapping("/")
	public String home1(Model model) {
		System.out.println("kiran");
		List<StoneStockVo> stockedStones = stoneService.getStockedStones();
		System.out.println(stockedStones);
		model.addAttribute("stoneStocks", stockedStones);
		return "common/home";
	}

	@GetMapping("/home")
	public String home(Model model) {
		System.out.println("kiran");
		List<StoneStockVo> stockedStones = stoneService.getStockedStones();
		System.out.println(stockedStones);
		model.addAttribute("stoneStocks", stockedStones);
		return "common/home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "common/admin";
	}

	@GetMapping("/user")
	public String user() {
		return "common/user";
	}

	@GetMapping("/about")
	public String about() {
		return "common/about";
	}

	@GetMapping("/login")
	public String login() {
		return "common/login";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

}
