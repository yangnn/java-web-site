package com.hyhg.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hyhg.Application;
import com.hyhg.domain.User;
import com.hyhg.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserServiceTest {

	
	@Resource
	private UserService userService;
	
	@Test
	public void testInsert(){
		User user = new User();
		user.setAge(11);
		user.setName("test");
		user.setPassword("test");
		userService.insert(user);
		
	}
	
}
