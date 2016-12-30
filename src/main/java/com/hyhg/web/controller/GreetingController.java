package com.hyhg.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name",required = false,defaultValue="world") String name,Model model){
		model.addAttribute("name",name);
		return "greeting";
	}
	
	@RequestMapping("/index")
	public String index(Model model){
		return "index";
	}
	
	@RequestMapping("/welcome")
	public String welcome(Model model){
		return "welcome";
	}
	
}
