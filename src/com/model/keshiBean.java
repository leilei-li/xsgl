package com.model;
public class keshiBean {
	private long id;
	private String keshi_name;
	private String boss;
	private String danwei_ID;
	private String danwei_name;
	//修改函数
	public void setId(long id) {
		this.id = id;
	}
	public void setkeshi_name(String keshi_name) {
		this.keshi_name = keshi_name;
	}
	public void setboss(String boss) {
		this.boss = boss;
	}
	public void setdanwei_ID(String danwei_ID) {
		this.danwei_ID = danwei_ID;
	}
	public void setdanwei_name(String danwei_name) {
		this.danwei_name = danwei_name;
	}
	//获取函数
	public long getId() {
		return id;
	}
	public String getkeshi_name() {
		return keshi_name;
	}
	public String getboss() {
		return boss;
	}
	public String getdanwei_ID() {
		return danwei_ID;
	}
	public String getdanwei_name() {
		return danwei_name;
	}
}
	
	
	