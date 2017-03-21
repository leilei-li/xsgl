package com.model;
public class userBean {
	private long id;
	private String userName;
	private String password;
	private String trueName;
	private String type;
	private String ID_num;
	private String re_ID;
	//修改函数
	public void setId(long id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setre_ID(String re_ID) {
		this.re_ID = re_ID;
	}
	public void setID_num(String ID_num) {
		this.ID_num = ID_num;
	}
	//获取函数
	public long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getTrueName() {
		return trueName;
	}
	public String getType() {
		return type;
	}
	public String getre_ID() {
		return re_ID;
	}
	public String getID_num() {
		return ID_num;
	}
}
	
	
	