package com.graphql.study.demo.util;

import static graphql.schema.GraphQLArgument.newArgument;
import static graphql.schema.GraphQLObjectType.newObject;

import java.util.ArrayList;
import java.util.List;

import com.graphql.study.demo.bean.User;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLOutputType;
import graphql.schema.GraphQLSchema;

public final class GraphQLInitializer {

	private static GraphQLOutputType userType;
	public static GraphQLSchema schema;

	//Hungry man singeton
	static {
		GraphSchema();
	}
	
	/**
	 * Init the output type
	 */
	private static void initOutputType() {

		userType = newObject().name("User")
				.field(GraphQLFieldDefinition.newFieldDefinition().name("id").type(Scalars.GraphQLLong).build())
				.field(GraphQLFieldDefinition.newFieldDefinition().name("age").type(Scalars.GraphQLShort).build())
				.field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString).build())
				.build();
	}

	/**
	 * Check single user
	 * 
	 */
	private static GraphQLFieldDefinition createUserField() {
		return GraphQLFieldDefinition.newFieldDefinition().name("user")
				.argument(newArgument().name("id").type(Scalars.GraphQLInt).build()).type(userType).dataFetcher(environment -> {
					// 获取查询参数
					int id = environment.getArgument("id");

					// 执行查询, 这里随便用一些测试数据来说明问题
					User user = new User();
					user.setId(id);
					user.setAge((short)id );
					user.setName("Name_" + id);
					return user;
				}).build();
	}

	/**
	 * Check multiple users
	 * 
	 */
	private static GraphQLFieldDefinition createUsersField() {
		return GraphQLFieldDefinition.newFieldDefinition().name("users")
				.argument(newArgument().name("page").type(Scalars.GraphQLInt).build())
				.argument(newArgument().name("size").type(Scalars.GraphQLInt).build())
				.argument(newArgument().name("name").type(Scalars.GraphQLString).build()).type(new GraphQLList(userType))
				.dataFetcher(environment -> {
					// 获取查询参数
					int page = environment.getArgument("page");
					int size = environment.getArgument("size");
					String name = environment.getArgument("name");

					// 执行查询, 这里随便用一些测试数据来说明问题
					List<User> list = new ArrayList<>(size);
					for (int i = 0; i < size; i++) {
						User user = new User();
						user.setId(i);
						user.setAge((short)i );
						user.setName("Name_" + i);
						list.add(user);
					}
					return list;
				}).build();
	}
	

    private static void GraphSchema() {
        initOutputType();
        schema = GraphQLSchema.newSchema().query(newObject()
                .name("GraphQuery")
                .field(createUsersField())
                .field(createUserField())
                .build()).build();
        
    }

}
