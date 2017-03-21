package com.model;

public class shoukuanBean {
	private long ID;
	private int shoukuan_ID;
	private String dingdan_ID;
	private String fapiao_ID;
	private String date;
	private String sales_name;
	private String kehu_ID;
	private String jizhang;
	private String shenhe;
	private String type;
	private float shishou;
	
	//如下是获取函数
	public long getID() {
		return ID;
	}
	public int getshoukuan_ID() {
		return shoukuan_ID;
	}
	public String getdingdan_ID() {
		return dingdan_ID;
	}
	public String getfapiao_ID() {
		return fapiao_ID;
	}
	public String getdate() {
		return date;
	}
	public String getsales_name() {
		return sales_name;
	}
	public String getkehu_ID() {
		return kehu_ID;
	}
	public String getjizhang() {
		return jizhang;
	}
	public String getshenhe() {
		return shenhe;
	}
	public String gettype() {
		return type;
	}
	public float getshishou() {
		return shishou;
	}
	
	//下面是修改函数
	public void setID(long id) {
		this.ID = ID;
	}
	public void setshoukuan_ID(int shoukuan_ID) {
		this.shoukuan_ID = shoukuan_ID;
	}
	public void setdingdan_ID(String dingdan_ID) {
		this.dingdan_ID = dingdan_ID;
	}
	public void setfapiao_ID(String fapiao_ID) {
		this.fapiao_ID = fapiao_ID;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public void setsales_name(String sales_name) {
		this.sales_name = sales_name;
	}
	public void setkehu_ID(String kehu_ID) {
		this.kehu_ID = kehu_ID;
	}
	public void setjizhang(String jizhang) {
		this.jizhang = jizhang;
	}
	public void setshenhe(String shenhe) {
		this.shenhe = shenhe;
	}
	public void settype(String type) {
		this.type = type;
	}
	public void setshishou(float shishou) {
		this.shishou = shishou;
	}
	
	
}