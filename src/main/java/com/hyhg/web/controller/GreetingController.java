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
	
	@RequestMapping("/about_us")
	public String about(Model model){
		return "about_us";
	}
	
	@RequestMapping("/blog")
	public String blog(Model model){
		return "blog";
	}
	
	@RequestMapping("/contacts")
	public String contacts(Model model){
		return "contacts";
	}
	
	@RequestMapping("/gallery")
	public String gallery(Model model){
		return "gallery";
	}
	
}
