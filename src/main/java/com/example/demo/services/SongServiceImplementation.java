package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Songs;
import com.example.demo.repositories.SongsRepositories;

@Service
public class SongServiceImplementation implements SongServices {

	@Autowired
	SongsRepositories repo;
	
	@Override
	public void addSong(Songs song) {
		repo.save(song);
	}

	@Override
	public List<Songs> viewAllSongs() {
		
		return repo.findAll();
		
	}

	@Override
	public boolean songExist(String name) {
		
		Songs song=repo.findByName(name);
		if(song!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void updateSong(Songs song) {
		repo.save(song);
	}

}
