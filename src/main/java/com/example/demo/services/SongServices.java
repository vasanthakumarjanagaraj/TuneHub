package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Songs;

public interface SongServices {

	public void addSong(Songs song);
	public List<Songs> viewAllSongs();
	public boolean songExist(String name);
	public void updateSong(Songs song);
}
