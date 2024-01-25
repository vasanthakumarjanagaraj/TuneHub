package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Playlist;

public interface PlayListServices {

	public void addPlayList(Playlist playList);
	public List<Playlist> viewAllPlaylist();
}
