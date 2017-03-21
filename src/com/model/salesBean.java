package com.model;


public class salesBean {
	private long ID;
	private String sales_ID;
	private String name;
	private String sex;
	private String CN_ID;
	private String mobile1;
	private String mobile2;
	private String inDate;
	private String duty;
	private String level;
	private float salary;
	private float royalty;
	private String Team_ID;
	private String favorite;
	private String character;
	private String email;
	private int flag;
	//如下是获取函数
	public long getID() {
		return ID;
	}
	public String getsales_ID() {
		return sales_ID;
	}
	public String getName() {
		return name;
	}
	public String getsex() {
		return sex;
	}
	public String getCN_ID() {
		return CN_ID;
	}
	public String getmobile1() {
		return mobile1;
	}
	public String getmobile2() {
		return mobile2;
	}
	public String getinDate() {
		return inDate;
	}
	public String getduty() {
		return duty;
	}
	public String getlevel() {
		return level;
	}
	
	public float getsalary() {
		return salary;
	}
	public float getroyalty() {
		return royalty;
	}
	public String getTeam_ID() {
		return Team_ID;
	}
	public String getfavorite() {
		return favorite;
	}
	public String getcharacter() {
		return character;
	}
	public String getemail() {
		return email;
	}
	public int getflag() {
		return flag;
	}
	//下面是修改函数
	public void setID(long id) {
		this.ID = ID;
	}
	public void setsales_ID(String sales_ID) {
		this.sales_ID = sales_ID;
	}
	public void setname(String name) {
		this.name = name;
	}
	public void setsex(String sex) {
		this.sex = sex;
	}
	public void setCN_ID(String CN_ID) {
		this.CN_ID = CN_ID;
	}
	public void setmobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public void setmobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public void setinDate(String inDate) {
		this.inDate = inDate;
	}
	public void setduty(String duty) {
		this.duty = duty;
	}
	public void setlevel(String level) {
		this.level = level;
	}
	
	public void setsalary(float salary) {
		this.salary = salary;
	}
	public void setroyalty(float royalty) {
		this.royalty = royalty;
	}
	
	public void setTeam_ID(String Team_ID) {
		this.Team_ID = Team_ID ;
	}
	public void setfavorite(String favorite) {
		this.favorite = favorite;
	}
	
	public void setcharacter(String character) {
		this.character = character;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public void setflag(int flag) {//用来标记可不可以导入
		this.flag = flag;
	}
	
}