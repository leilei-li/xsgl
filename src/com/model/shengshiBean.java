package com.model;
public class shengshiBean {
	private long id;
	private String province;
	private String city;
	private String priority;
	//修改函数
	public void setId(long id) {
		this.id = id;
	}
	public void setprovince(String province) {
		this.province = province;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public void setpriority(String priority) {
		this.priority = priority;
	}
	//获取函数
	public long getId() {
		return id;
	}
	public String getcity() {
		return city;
	}
	public String getprovince() {
		return province;
	}
	public String getpriority() {
		return priority;
	}
}
	
	
	