package com.emon.springboot02.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
	
	private Map<String, Object> params = new HashMap<String, Object>();
	
	/**
	 * 功能描述：restful协议，从路径中获取字段
	 * @param cityId
	 * @param userId
	 * @return
	 */
	@RequestMapping(path = "{city_id}/{user_id}",method = RequestMethod.GET)
	public Object findUser(@PathVariable("city_id") String cityId,
			@PathVariable("user_id") String userId) {
		// 在参数声明(@PathVariable("city_id") String cityId,...)中
		// 其中cityId要和注解中的{city_id}对应
		// 由于在此案例中参数变量名为cityId 不等于注解中定义的 city_id
		// 所以要使用@PathVariable("city_id")将city_id与cityId对应
		params.clear();
		params.put("cityId", cityId);
		params.put("userId", userId);
		
		return params;
		
	}
	
	/**
	 * 功能描述：测试GetMapping
	 * 对restful协议进行进一步封装
	 * @param from
	 * @param size
	 * @return
	 */
	@GetMapping(value = "/v1/page_user1")
	public Object pageUser(int from, int size) {
		// 可以直接使用
		// localhost:8080/v1/page_user?size=10&from=1
		// 访问并获取数据
		params.clear();
		params.put("from", from);
		params.put("size", size);
		
		return params;
	}
	
	/**
	 * 功能描述：默认值 必须字段
	 * 对restful协议进行进一步封装
	 * @param from
	 * @param size
	 * @return
	 */
	@GetMapping(value = "/v1/page_user2")
	//public Object pageUser2(@RequestParam(defaultValue = "0",name = "page",required=true) int from, int size) { - reuqired 为必填项
	public Object pageUser2(@RequestParam(defaultValue = "0",name = "page") int from, int size) {
		// name = "page" 意为将地址中的page变量映射到from变量中，需要在地址中使用page而非变量名from
		// localhost:8080/v1/page_user2?size=10&page=1
		// 如果不填写page变量，如 localhost:8080/v1/page_user2?size=10
		// from变量会默认设为0
		params.clear();
		params.put("from", from);
		params.put("size", size);
		
		return params;
	}
	


}
