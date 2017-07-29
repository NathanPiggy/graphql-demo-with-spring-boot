package com.graphql.study.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.graphql.study.demo.bean.User;

@Mapper
public interface UserMapper{
	
	/**
	 * Check the user
	 */
	 @Select("select * from user where id=#{id}")
	public User getUser(@Param("id") int id);
}
