package com.example.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository repository;
	
	public User findUser(String username, String password) {
		User user = new User();
		
		try {
			user = repository.findByUsername(username, password);
		}catch(Exception e) {
			user = null;
		}
		
		return user;
	}
	
	public void updateUser(Date date, String username) {
		repository.updateLastLogin(date, username);
	}
	
	public String getLastLogin(String username) {
		Date date = repository.getLastLogin(username);
		DateFormat dt = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		String str = dt.format(date);
		return str;
	}
	
	public Date getLocalDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		Date localDate = null;
		try {
			localDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dtf.format(now));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return localDate;
	}
	
}
