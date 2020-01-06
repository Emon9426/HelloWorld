package com.emon.springboot02.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	// Bean对象
	// 为测试GetController加入
	@JsonInclude(Include.NON_NULL)
	private int age;
	@JsonIgnore
	private String pwd;
	@JsonProperty("ACCUNT")
	private String phone; //使用@JsonProperty起别名
	@JsonFormat(pattern = "yyyy-mm-dd", locale = "zh", timezone = "GMT+8")
	private Date createTime;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User(int age, String pwd, String phone, Date createTime) {
		super();
		this.age = age;
		this.pwd = pwd;
		this.phone = phone;
		this.createTime = createTime;
	}

	
}
