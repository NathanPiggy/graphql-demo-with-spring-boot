package com.graphql.study.demo.service.imp;

import com.graphql.study.demo.GraphqlJavaServerDemoApplication;
import com.graphql.study.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GraphqlJavaServerDemoApplication.class)
public class UserServiceImpTest {

    @Autowired
    private UserService userService;

    @Test
    public void getRandomNumber() {
        assertTrue(userService.getRandomNumber() > 5);
    }
}