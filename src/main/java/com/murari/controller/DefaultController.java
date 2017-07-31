package com.murari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
	@GetMapping("/")
	public String home1() {
		return "common/home";
	}

	@GetMapping("/home")
	public String home() {
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
