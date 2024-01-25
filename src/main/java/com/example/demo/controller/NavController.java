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
	
	
	
	
	
}
