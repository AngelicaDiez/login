package com.example.service;

import java.util.Date;

import com.example.entity.User;

public interface LoginService {

	public User findUser(String username, String password);
	
	public void updateUser(Date date, String username);
	
	public String getLastLogin(String username);
	
	public Date getLocalDate();
}
