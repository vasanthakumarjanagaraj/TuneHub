package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepositories;

@Service
public class UserServiceImplementation implements UserServices{

	@Autowired
	UsersRepositories repo;
	
	@Override
	public void addUser(Users user) {
		repo.save(user);
	}

	@Override
	public boolean emailExist(String email) {
	    if(repo.findByEmail(email)==null) {
	    	return false;
	    }
	    else {
	    
	    	return true;
	    }
	    	
	    	
		
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user=repo.findByEmail(email);
		if(user!=null
		 && user.getPassword().equals(password)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public String findRole(String email) {
		String role=repo.findByEmail(email).getRole();
		return role;
	}

	@Override
	public Users getUser(String email) {
		
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
	}

}
