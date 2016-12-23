package com.hyhg;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;


@SpringBootApplication
@Controller
public class Application {

	@RequestMapping("/")
	@ResponseBody
	public String index(){
		return "hello world";
	}
	
	public static void main(String args[]){
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public RequestContextListener requestContextListener(){
	    RequestContextListener requestContextListener = new RequestContextListener();
	    return requestContextListener;
	}
	
}

