package com.model;


public class fapiaoBean {
	private long ID;
	private String fapiao_ID;
	private String fapiao_num;
	private String create_date;
	private String dingdan_ID;
	private float money;
	private String cus_ID;
	private String cus_name;
	private String sales_ID;
	private String sales_name;
	private float shishou;
	private String state;
	private String fapiaotaitou;
	private String user_ID;
	private int flag;
	//如下是获取函数
	public long getID() {
		return ID;
	}
	public String getfapiao_ID() {
		return fapiao_ID;
	}
	public String getcreate_date() {
		return create_date;
	}
	public String getdingdan_ID() {
		return dingdan_ID;
	}
	public Float getmoney() {
		return money;
	}
	public String getcus_ID() {
		return cus_ID;
	}
	public String getsales_ID() {
		return sales_ID;
	}
	public Float getshishou() {
		return shishou;
	}
	public String getstate() {
		return state;
	}
	public String getfapiaotaitou() {
		return fapiaotaitou;
	}
	
	public String getuser_ID() {
		return user_ID;
	}
	public String getcus_name() {
		return cus_name;
	}
	public String getsales_name() {
		return sales_name;
	}
	public int getflag() {
		return flag;
	}
	
	//下面是修改函数
	public void setID(long id) {
		this.ID = ID;
	}
	public void setfapiao_ID(String fapiao_ID) {
		this.fapiao_ID = fapiao_ID;
	}
	public void setfapiao_num(String fapiao_num) {
		this.fapiao_num = fapiao_num;
	}
	public void setcreate_date(String create_date) {
		this.create_date = create_date;
	}
	public void setdingdan_ID(String dingdan_ID) {
		this.dingdan_ID = dingdan_ID;
	}
	public void setmoney(float money) {
		this.money = money;
	}
	public void setcus_ID(String cus_ID) {
		this.cus_ID = cus_ID;
	}
	public void setsales_ID(String sales_ID) {
		this.sales_ID = sales_ID;
	}
	public void setstate(String state) {
		this.state = state;
	}
	public void setshishou(float shishou) {
		this.shishou = shishou;
	}
	public void setfapiaotaitou(String fapiaotaitou) {
		this.fapiaotaitou = fapiaotaitou;
	}
	
	public void setuser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public void setcus_name(String cus_name) {
		this.cus_name = cus_name;
	}
	public void setsales_name(String sales_name) {
		this.sales_name = sales_name;
	}
	public void setflag(int flag) {
		this.flag = flag;
	}
	
}