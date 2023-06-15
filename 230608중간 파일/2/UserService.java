package com.coding404.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
	//추상메서드 
	int join(HttpServletRequest reqeust, HttpServletResponse response); 
	int login(HttpServletRequest reqeust, HttpServletResponse response);

}
