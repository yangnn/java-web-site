package com.hyhg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hyhg.domain.User;
import com.hyhg.service.UserService;

@RestController
@RequestMapping("/hyhg/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/add")
	public void add(){
		User user = new User();
		user.setAge(1);
		user.setName("11");
		user.setPassword("qq");
		userService.insert(user);
		
	}
	
}
