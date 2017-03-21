package com.model;


public class duizhangBean {
	private long ID;
	private String cus_name;
	private String sales_name;
	private String cus_ID;
	private String sales_ID;
	private String date;
	private String dingdan_ID;
	private String yangpinmiaoshu;
	private String type;
	private String sample_num;//样品号
	private float num;
	private float price;
	private float total_price;
	private int duizhang_ID;
	private String username;
	private String fapiao_ID;
	private String danwei_name;
	private String keshi_name;
	private int flag;
	//如下是获取函数
	public long getID() {
			return ID;
	}
	public String getcus_name() {
		return cus_name;
	}
	public String getsales_name() {
		return sales_name;
	}
	public String getcus_ID() {
		return cus_ID;
	}
	public String getsales_ID() {
		return sales_ID;
	}
	public String getdate() {
		return date;
	}
	public String getdingdan_ID() {
		return dingdan_ID;
	}
	public String getyangpinmiaoshu() {
		return yangpinmiaoshu;
	}
	public String gettype() {
		return type;
	}
	public String getsample_num() {
		return sample_num;
	}
	public float getnum() {
		return num;
	}
	public float getprice() {
		return price;
	}
	public float gettotal_price() {
		return total_price;
	}
	public int getduizhang_ID() {
		return duizhang_ID;
	}
	public String getusername() {
		return username;
	}
	public String getfapiao_ID() {
		return fapiao_ID;
	}
	public String getdanwei_name() {
		return danwei_name;
	}
	public String getkeshi_name() {
		return keshi_name;
	}
	public int getflag() {
		return flag;
	}
	//下面是修改函数
    public void setID(long id) {
			this.ID = ID;
	}
  	public void setcus_name(String cus_name) {
  		this.cus_name = cus_name;
  	}
  	public void setcus_ID(String cus_ID) {
  		this.cus_ID = cus_ID;
  	}
  	public void setsales_name(String sales_name) {
  		this.sales_name = sales_name;
  	}
  	public void setsales_ID(String sales_ID) {
  		this.sales_ID = sales_ID;
  	}
  	public void setdate(String date) {
  		this.date = date;
  	}
  	public void setdingdan_ID(String dingdan_ID) {
  		this.dingdan_ID = dingdan_ID;
  	}
  	public void setyangpinmiaoshu(String yangpinmiaoshu) {
  		this.yangpinmiaoshu = yangpinmiaoshu;
  	}
  	public void settype(String type) {
  		this.type = type;
  	}
  	public void setsample_num(String sample_num) {
  		this.sample_num = sample_num;
  	}
  	public void setnum(float num) {
  		this.num = num;
  	}
  	public void setprice(float price) {
  		this.price = price;
  	}
  	public void settotal_price(float total_price) {
  		this.total_price = total_price;
  	}
  	public void setduizhang_ID(int duizhang_ID) {
  		this.duizhang_ID = duizhang_ID;
  	}
  	public void setusername(String username) {
  		this.username = username;
  	}
  	public void setfapiao_ID(String fapiao_ID) {
  		this.fapiao_ID = fapiao_ID;
  	}
  	public void setdanwei_name(String danwei_name) {
  		this.danwei_name = danwei_name;
  	}
  	public void setkeshi_name(String keshi_name) {
  		this.keshi_name = keshi_name;
  	}
  	public void setflag(int flag) {
  		this.flag = flag;
  	}
  	
  	
}