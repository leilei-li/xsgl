package com.model;
public class giftBean {
	private long gift_ID;
	private String gift_name;
	private float gift_num;
	private float  gift_value;
	private float  jifen;
	private int flag;
	//修改函数
	
	public void setgift_ID(long gift_ID) {
		this.gift_ID = gift_ID;
	}
	public void setgift_name(String gift_name) {
		this.gift_name = gift_name;
	}
	public void setgift_num(float gift_num) {
		this.gift_num = gift_num;
	}
	public void setgift_value(float gift_value) {
		this.gift_value = gift_value;
	}
	public void setjifen(float jifen) {
		this.jifen = jifen;
	}
	public void setflag(int flag) {
		this.flag = flag;
	}
	//获取函数
	public long getgift_ID() {
		return gift_ID;
	}
	public String getgift_name() {
		return gift_name;
	}
	public float getgift_num() {
		return gift_num;
	}
	public float getgift_value() {
		return gift_value;
	}
	public float getjifen() {
		return jifen;
	}
	public int getflag() {
		return flag;
	}
	
}
	
	
	