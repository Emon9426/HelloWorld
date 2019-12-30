package com.emon.springboot02.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emon.springboot02.domain.User;

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
	
	/**
	 * 功能描述：使用bean对象传参
	 * 注意：
	 * 	1. 使用POST时，注意需指定http头 content-type为application/json
	 *  2. 使用body传输数据
	 *Memo：
	 *	从页面中获取一个JSON格式的对象
	 *	自动将JSON中的属性匹配到Bean中
	 */
	@RequestMapping("/v1/save_user")
	public Object saveUser(@RequestBody User user) {
		params.clear();
		params.put("user", user);
		params.put("user2", user.getAge());
		return params;
	}
	
	/**
	 * 功能描述：获取HTTP头信息
	 *Memo:
	 *	测试时GET连接 localhost:8080/v1/get_header?id=333
	 *	在header中添加 access_token 和对应的值
	 */
	@GetMapping("/v1/get_header")
	public Object getHeader(@RequestHeader("access_token") String accessToken, String id) {
		params.clear();
		params.put("access_toker", accessToken);
		params.put("id", id);
		return params;
	}
	
	/**
	 * 功能描述：Request
	 */
	@GetMapping("/v1/test_request")
	public Object testRequest(HttpServletRequest request) {
		params.clear();
		String id = request.getParameter("id");
		params.put("id", id);
		return params;
	}

/* Memo
1.关于GET和POST
	<相同点>
		GET和POST两种方法都是将数据送到服务器
	<不同点>
		POST: 
			1.POST 不会将数据作为URL一部分，不会被缓存，保存在日志文件或浏览器浏览记录中
			2.POST 能够发送的数据最多，没有URL长度的限制
			3.POST 能够发送更多的数据类型
			4.POST 更慢
			5.POST 用于修改和写入数据 (每次请求后返回的结果都会变化)
		GET:
			1.GET 的数据会被作为URL的一部分而保存起来
			2.GET 的数据长度受URL最大长度的限制
			3.GET 只能够发送ASCII的字符
			4.GET 比POST更快
			5.GET 多用于搜索排序和筛选之类的工作，目的多为资源的获取，读取数据 (每次请求后，返回的结果都不变 - 幂等请求)
	<说明>
		1. POST比GET慢：
			1-1. 因为POST的数据中包括head部分
			1-2. 请求的方式不同，GET的速度为POST的2/3左右
				POST：
					浏览器 → 请求TCP连接         - 第一次握手
					服务器 → 同意进行TCP连接  - 第二次握手
					浏览器 → 确认并发送请求头 - 第三次握手
					服务器 → 返回100 Continue响应
					浏览器 → 发送数据
					服务器 → 返回200 OK响应
				GET:
					浏览器 → 请求TCP连接        - 第一次握手
					服务器 → 同意进行TCP连接 - 第二次握手
					浏览器 → 发送数据             - 第三次握手
					服务器 → 返回200 OK响应
 			1-3.GET会将数据缓存起来，POST不会
 			1-4.POST不会进行管道化传输
 				* 管道化传输：将多个请求排成队列，发送完一个以后，无需等待服务器返回的结果，就将第二个请求发送出去
  
  

 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
