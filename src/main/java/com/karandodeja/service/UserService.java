package com.karandodeja.service;

import com.karandodeja.model.User;

public interface UserService {
	
	public User findUserById(Long userId) throws Exception;
	
}
