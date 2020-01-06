package com.emon.springboot02.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emon.springboot02.domain.User;

@RestController
public class JsonClass {
	
	//private Map<Object, String> map = new HashMap<>();
	
	@GetMapping("/testjson")
	public Object testJson(){
		
		return new User(11, "abc123", "111111", new Date());
	}
}
