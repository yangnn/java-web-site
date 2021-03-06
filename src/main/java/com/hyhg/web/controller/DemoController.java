package com.hyhg.web.controller;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Value("${web.db.username}")
	String database;
	
	@RequestMapping("/appInfo")
	public String info(){
		logger.info("request for /appInfo...");
		return "database : " + database;
	}
	
	
	@GetMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		return "welcome";
	}
}
