package com.murari.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class WelcomeController {
	
	private @Value("${welcome.message:test}")String message;
	
//	@RequestMapping("/")
	public String welcome(Map<String, Object> model){
		model.put("message", this.message);
		return "home/welcome";
		
	}
	

}
