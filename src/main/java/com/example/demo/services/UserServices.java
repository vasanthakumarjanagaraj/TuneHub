package com.example.demo.services;

import com.example.demo.entities.Users;

public interface UserServices {

	public void addUser(Users user);
	public boolean emailExist(String email);
	public boolean validateUser(String email,String password);
	public String findRole(String email);
	public Users getUser(String email);
	public void updateUser(Users user);
}
