
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.entities.Playlist;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlayListServices;
import com.example.demo.services.SongServices;


@Controller
public class PlayListController {
	
	@Autowired
	SongServices songService;
	
	@Autowired
	PlayListServices playListService;
	
	
	@GetMapping("createplaylist")
	public String cratePlayList(Model model) {
		model.addAttribute("songs", songService.viewAllSongs());
		return "createplaylist";
	}

	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute Playlist playlist) {
		//adding playList table
		playListService.addPlayList(playlist);
		System.out.println("Playlist added");
		//updating song table in db
		List<Songs> songList=playlist.getSongs();
		for(Songs s: songList) {
			//adding playList value in song object
			s.getPlaylist().add(playlist);;
			//saving updated song object value in db
			songService.updateSong(s);
		}
		
		
		System.out.println("playlist added");
		
		return "adminlogin";
	}
	
	@GetMapping("/viewallplaylist")
	public String viewAllPlayList(Model model) {
		
		model.addAttribute("allPlaylist", playListService.viewAllPlaylist());
		return"viewallplaylist";
	}
	
}
