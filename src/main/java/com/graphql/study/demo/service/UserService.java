package com.graphql.study.demo.service;

import com.graphql.study.demo.bean.User;

public interface UserService {

	/**
	 * Get the user info with id
	 * @return
	 */
	public User getUser(int id);
	
}
