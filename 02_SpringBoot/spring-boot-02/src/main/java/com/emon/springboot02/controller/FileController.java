package com.emon.springboot02.controller;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.emon.springboot02.domain.JsonData;

@Controller
public class FileController {
	
	private static final String filePath = "C:\\WorkSpace\\00_Git\\02_SpringBoot\\spring-boot-02\\src\\main\\resources\\static\\"; //文件路径
	
	@RequestMapping(value = "/v3/gopage")
	public Object index() {
		return "index";
	}
	
	@RequestMapping(value = "/v3/upload")
	@ResponseBody
	//@RequestMapping对应html中的action
	//@RequestParam用于匹配name，如果没有@RequestParam，则file要改成head_img
	//HttpServletRequest用于获取表单字段
	public Object upload(
			@RequestParam("head_img") MultipartFile file,
			HttpServletRequest request) {
		
		
		String name = request.getParameter("name");
		System.out.println("用户名："+name);
		
		//获取文件名
		String filename = file.getOriginalFilename();
		System.out.println("上传的文件名为："+filename);
		
		//获取文件扩展名
		String suffixName = filename.substring(filename.lastIndexOf("."));
		System.out.println("上传的文件扩展名为："+suffixName);
		
		//文件上传后的路径
		filename = UUID.randomUUID() + suffixName; //随机数，由于文件名可能重复，所以不能作为为义标识
		File dest = new File(filePath + filename);
		
		//校验
		//file.isEmpty(); //非空校验
		//file.getSize(); //获取文件大小校验
		
		try {
			file.transferTo(dest);
			return new JsonData(0, filename,"Succ");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JsonData(-1, filename,"fail");
	}
	
}
