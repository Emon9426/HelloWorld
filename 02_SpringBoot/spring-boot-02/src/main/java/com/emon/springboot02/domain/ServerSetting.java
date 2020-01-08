package com.emon.springboot02.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//服务器配置
@Component
@PropertySource({"classpath:application.properties"})
//@ConfigurationProperties
@ConfigurationProperties(prefix="test")
public class ServerSetting {
	
	//服务器名称
	//@Value("${test.name}")
	@Value("name")
	private String name;
	//域名地址
	//@Value("${test.domain}")
	@Value("domain")
	private String domain;
	
	/**
	 * 在application.properies中，属性为 test.name
	 * 当使用 @ConfigurationProperties 时，下面的@Value("${test.name}")
	 * 需要使用${test.name}的方式获取注入
	 * 当使用@@ConfigurationProperties(prefix="test") 时，可以省略test. 直接为 @Value("name")
	 * @ConfigurationProperties(prefix="test") 为前缀的设置，前缀设置后只需要通过key名称读取
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
}
