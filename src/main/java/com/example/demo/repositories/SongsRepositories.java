package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Songs;

public interface SongsRepositories extends JpaRepository<Songs, Integer>{

         public Songs findByName(String name);
}
