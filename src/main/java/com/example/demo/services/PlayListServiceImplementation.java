package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlayListRepositories;

@Service
public class PlayListServiceImplementation implements PlayListServices{

	@Autowired
	PlayListRepositories repo;
	
	
	
	@Override
	public void addPlayList(Playlist playList) {
		repo.save(playList);
		
	}



	@Override
	public List<Playlist> viewAllPlaylist() {
		
		return repo.findAll();
	}



	

}
