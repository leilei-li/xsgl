package com.model;

public class visitBean {
	private long ID;
	private String sale_ID;
	private String customer_ID;
	private String didian;
	private String date;
	private String reason;
	private String gift;
	private float gift_num;
	private String result;
	private String sales_name;
	private String cus_name;
	//如下是获取函数
	public long getID() {
		return ID;
	}
	public String getsale_ID() {
		return sale_ID;
	}
	public String getcustomer_ID() {
		return customer_ID;
	}
	public String getdidian() {
		return didian;
	}
	public String getdate() {
		return date;
	}
	public String getreason() {
		return reason;
	}
	public String getgift() {
		return gift;
	}
	public float getgift_num() {
		return gift_num;
	}
	public String getresult() {
		return result;
	}
	public String getsales_name() {
		return sales_name;
	}
	public String getcus_name() {
		return cus_name;
	}
	
	
	//下面是修改函数
	public void setID(long ID) {
		this.ID = ID;
	}
	public void setsale_ID(String sale_ID) {
		this.sale_ID = sale_ID;
	}
	public void setcustomer_ID(String customer_ID) {
		this.customer_ID = customer_ID;
	}
	public void setdidian(String didian) {
		this.didian = didian;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public void setreason(String reason) {
		this.reason = reason;
	}
	public void setgift(String gift) {
		this.gift = gift;
	}
	public void setgift_num(float gift_num) {
		this.gift_num = gift_num;
	}
	public void setresult(String result) {
		this.result = result;
	}
	public void setsales_name(String sales_name) {
		this.sales_name = sales_name;
	}
	public void setcus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	
}