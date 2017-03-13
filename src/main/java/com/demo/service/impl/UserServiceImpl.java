package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserMapper;
import com.demo.domain.User;
import com.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	//注入dao
	@Autowired
	private UserMapper userMapper ; 

	public void addUser(User user) {
			userMapper.insert(user);
	}

	public User getIdByUser(int uid) {
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<User> getAllUser() {
//		return userMapper.getAllUser();
//	}
//
//	@Override
//	public User getUser(String name) {
//		return userMapper.getUserByName(name);
//	}

}
