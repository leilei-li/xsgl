package com.model;

public class teamBean {
	private long ID;
	private String team_ID;
	private String team_name;
	private String leader;
	private String teamcol;
	private String team_goal;
	
	//如下是获取函数
	public long getID() {
		return ID;
	}
	public String getteam_ID() {
		return team_ID;
	}
	public String getteam_name() {
		return team_name;
	}
	public String getleader() {
		return leader;
	}
	public String getteamcole() {
		return teamcol;
	}
	public String getteam_goal() {
		return team_goal;
	}
	
	
	//下面是修改函数
	public void setID(long id) {
		this.ID = ID;
	}
	public void setteam_ID(String team_ID) {
		this.team_ID = team_ID;
	}
	public void setteam_name(String team_name) {
		this.team_name = team_name;
	}
	public void setleader(String leader) {
		this.leader = leader;
	}
	public void setteamcol(String teamcol) {
		this.teamcol = teamcol;
	}
	public void setteam_goal(String team_goal) {
		this.team_goal = team_goal;
	}
	
	
}