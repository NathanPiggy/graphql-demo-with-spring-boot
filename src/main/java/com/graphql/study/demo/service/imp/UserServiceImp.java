package com.graphql.study.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.study.demo.bean.User;
import com.graphql.study.demo.dao.UserMapper;
import com.graphql.study.demo.service.UserService;

@Service
public class UserServiceImp implements UserService {

	//Inject the usermapper proxy instance
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUser(int id) {
		return userMapper.getUser(id);
	}

	@Override
	public int getRandomNumber() {
		int randomNum = (int)(Math.random()*10);
		System.out.println("random result:" + randomNum);
		return randomNum;
	}


}
