package com.emon.demo.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class SampleController {
	
	@RequestMapping("/")
	@ResponseBody
	// 当找不到上面两个注解的时候，需要查看pom为文件中有没有spring-boot-starter-web依赖
	String home() {
		return "Hello World";
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}
}
