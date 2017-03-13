package com.demo.dto;

import com.demo.domain.User;

public class ResponseDto {

	public User user_info ; 
	public User getUser_info() {
		return user_info;
	}
	public void setUser_info(User user_info) {
		this.user_info = user_info;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String info ; 
	public String error ; 

}
