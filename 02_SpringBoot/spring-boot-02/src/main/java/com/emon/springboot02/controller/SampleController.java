package com.emon.springboot02.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
// @RestController包含了@@ResponseBody注解，所以在Map方法中，不需要再添加@@ResponseBody
@RestController
public class SampleController {
	
	@RequestMapping("/")
	@ResponseBody
	// 当找不到上面两个注解的时候，需要查看pom为文件中有没有spring-boot-starter-web依赖
	String home() {
		return "Hello World";
	}
	
	/* 在这个例子中，已经在SpringBoot02Application中定义了main方法，所以不可以再有main方法
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleController.class, args);
	}*/
	
	// 在@RestController中包含了@ResponseBody，所以只不再需要@ResponseBody注解
	@RequestMapping("/TEST")	
	public Map<String, String> testMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "testname");
		return map;
	}
	
}
