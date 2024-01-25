package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Songs;
import com.example.demo.services.SongServices;
import com.example.demo.services.UserServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class SongController {

	@Autowired
	SongServices service;
	
	@Autowired
	UserServices userService;
	
	@PostMapping("/addsong")
	public String addSong(@ModelAttribute Songs song ) {
		if(service.songExist(song.getName())==false) {
			service.addSong(song);
		return "adminlogin";
		}else {
			return "songexist";
		}
		
	}
	
	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		List<Songs> songList=service.viewAllSongs();
		
		model.addAttribute("songs", songList);
		
		return "viewsongs";
	}
	
	@GetMapping("/isPrimeUser")
	public String isPrimeUser(Model model,HttpSession session) {
		String userEmail=(String)session.getAttribute("email");
		boolean prime=userService.getUser(userEmail).isPrime();
		if(prime==true) {
			List<Songs> songList=service.viewAllSongs();
			model.addAttribute("songs", songList);
			return "viewsongs";
		}
		else {
		return "makepayment";
	}
		
	}
	
}
