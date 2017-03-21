package com.model;
public class priceBean {
	private long ID;
	private String name;
	private String class_name;
	private String type;
	private Float qi;
	private Float zhi;
	private Float price;
	//修改函数
	public void setID(long ID) {
		this.ID = ID;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setclass_name(String class_name) {
		this.class_name = class_name;
	}
	public void settype(String type) {
		this.type = type;
	}
	public void setqi(Float qi) {
		this.qi = qi;
	}
	public void setzhi(Float zhi) {
		this.zhi = zhi;
	}
	public void setprice(Float price) {
		this.price = price;
	}
	//获取函数
	public long getID() {
		return ID;
	}
	public String getname() {
		return name;
	}
	public String getclass_name() {
		return class_name;
	}
	public String gettype() {
		return type;
	}
	public Float getqi() {
		return qi;
	}
	public Float getzhi() {
		return zhi;
	}
	public Float getprice() {
		return price;
	}
}
	
	
	