package com.emon.springboot02.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//用于测试HTTP协议的GET POST DEL PUT请求

@RestController
public class OtherHttpController {
	
	private Map<String,Object> params = new HashMap<>();
	
	
	
	/**
	 * 功能描述：测试PostMapping
	 * Memo：
	 * 	测试连接：localhost:8080/v2/login
	 * 	在Body中添加form-data
	 * 	常用于提交要保存的信息
	 */
	@PostMapping("/v2/login")
	public Object login(String id,String pwd) {
		params.clear();
		params.put("id", id);
		params.put("pwd", pwd);
		return params;
	}
	
	/**
	 * 功能描述： 测试PutMapping
	 * Memo:
	 * 	常用于更新操作
	 * 	测试连接：localhost:8080/v2/put?id=10000
	 */
	@PutMapping("/v2/put")
	public Object put(String id) {
		params.clear();
		params.put("id",id);
		return params;
	}
	
	/**
	 * 功能描述：测试DeleteMapping
	 * Memo：
	 * 	用于删除操作
	 * 	测试连接：localhost:8080/v2/del?id=10000
	 */
	@DeleteMapping("v2/del")
	public Object del(String id) {
		params.clear();
		params.put("id",id);
		return params;
	}
	
	
	
	
	
}
