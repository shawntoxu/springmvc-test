package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.domain.User;

public interface UserService {
	void addUser(User user);
	User getIdByUser(int uid);
	List<User> getAllUser();
	User getUser(String name);
	
}
