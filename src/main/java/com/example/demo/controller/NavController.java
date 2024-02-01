package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class NavController {

	@GetMapping({"/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping({"/register"})
	public String register() {
		return "register";
	}
	
	@GetMapping("/addsong")
	public String addSong() {
		return "addsong";
	}
	@GetMapping("/aboutnew")
	public String aboutPage() {
		return "about";
	}
	@GetMapping("/home")
	public String homePage() {
		return "index";
	}
	@GetMapping("/privacy")
	public String privacypolicy() {
		return "privacypolicy";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
	
	
	
	
	
}
