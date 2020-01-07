package com.emon.springboot02;

import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.MultipartConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBoot02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02Application.class, args);
	}
	
	/**
	 * 用于配置上传文件的大小限制
	 * 必须放在有configuration注解下的类中
	 * 由于@SpringBootApplication包含了@SpringBootConfiguration和@EnableAutoConfiguration
	 * 所以可以放在此处
	 */
	@Bean
	public MultipartConfigElement multipartConfig() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件的最大size
		factory.setMaxFileSize("10240KB");
		// 总上传数据总大小
		factory.setMaxRequestSize("1024000KB");
		
		return factory.createMultipartConfig();
	}

}
