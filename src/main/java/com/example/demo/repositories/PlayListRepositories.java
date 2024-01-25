package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Songs;

public interface PlayListRepositories extends JpaRepository<Playlist, Integer>{

}
