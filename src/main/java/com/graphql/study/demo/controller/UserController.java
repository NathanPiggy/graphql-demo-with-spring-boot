package com.graphql.study.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.graphql.study.demo.util.GraphQLInitializer;

import graphql.GraphQL;

@RestController
public class UserController {

	/**
	 * Used for test the Graphql
	 * 
	 * @param query
	 * @return
	 */
	@PostMapping(value = "demo")
	public String demo(@RequestParam(value = "query", required = false) String query) {

		/*
		 * Query example:
		 * 
		 * String query1 = "{users(page:2,size:5,name:\"john\") {id,name}}";
		 * String query2 = "{user(id:6) {id,name}}"; String query3 =
		 * "{user(id:6) {id,name},users(page:2,size:5,name:\"john\") {id,name}}"
		 * ;
		 */

		//Fetch the result with query string
		Map<String, Object> result = new GraphQL(GraphQLInitializer.schema).execute(query).getData();
		
		return JSON
				.toJSONString(result == null ? "Invaid query! \n Please correct the query and try again. : )" : result);
	}

}
