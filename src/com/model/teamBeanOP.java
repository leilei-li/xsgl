package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class teamBeanOP {
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
public void close(){
		
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(ps!=null){
				ps.close();
				ps=null;
			}
			if(!ct.isClosed()){
				ct.close();
				ct=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}



public boolean creatTeam(String team_ID,String team_name,String leader,String teamcol,String team_goal){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into team(team_ID,team_name,leader,teamcol,team_goal) values(?,?,?,?,?)");
		ps.setString(1, team_ID);
		ps.setString(2, team_name);
		ps.setString(3,leader);
		ps.setString(4,teamcol);
		ps.setString(5,team_goal);
		
		
		
		int a=ps.executeUpdate();
		
		if(a==1)b=true;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return b;
}

public boolean modifyTeam(String team_ID,String team_name,String leader,String teamcol,String team_goal){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update team set team_name=?,leader=?,teamcol=?,team_goal=? where team_ID=?");
		
		ps.setString(1, team_name);//第一个问号是team_name
		ps.setString(2,leader);
		ps.setString(3,teamcol);
		ps.setString(4,team_goal);

		ps.setString(5, team_ID);
		
		int a=ps.executeUpdate();
		
		if(a==1)b=true;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return b;
}

public ArrayList<teamBean> getTeam_team_ID(String team_ID){
	ArrayList<teamBean> al=new ArrayList<teamBean>();
	teamBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from team where team_ID like '%"+team_ID+"%'  order by team_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new teamBean();
			
			ub.setID(rs.getLong(1));
			ub.setteam_ID(rs.getString(2));
			ub.setteam_name(rs.getString(3));
			ub.setleader(rs.getString(4));
			ub.setteamcol(rs.getString(5));
			ub.setteam_goal(rs.getString(6));
			
			
			al.add(ub);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return al;
}

public ArrayList<teamBean> getTeam(String team_name, String team_ID){
	ArrayList<teamBean> al=new ArrayList<teamBean>();
	teamBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from team where team_ID like '%"+team_ID+"%' and team_name like '%"+team_name+"%' order by team_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new teamBean();
			
			ub.setID(rs.getLong(1));
			ub.setteam_ID(rs.getString(2));
			ub.setteam_name(rs.getString(3));
			ub.setleader(rs.getString(4));
			ub.setteamcol(rs.getString(5));
			ub.setteam_goal(rs.getString(6));
			
			
			al.add(ub);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return al;
}

public ArrayList<teamBean> getTeam_name(String team_name){
	ArrayList<teamBean> al=new ArrayList<teamBean>();
	teamBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from team where team_name like '%"+team_name+"%'  order by team_name ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new teamBean();
			
			ub.setID(rs.getLong(1));
			ub.setteam_ID(rs.getString(2));
			ub.setteam_name(rs.getString(3));
			ub.setleader(rs.getString(4));
			ub.setteamcol(rs.getString(5));
			ub.setteam_goal(rs.getString(6));
			
			
			al.add(ub);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return al;
}
public ArrayList<teamBean> getTeam_leader(String leader){
	ArrayList<teamBean> al=new ArrayList<teamBean>();
	teamBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from team where leader like '%"+leader+"%'  order by leader ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new teamBean();
			
			ub.setID(rs.getLong(1));
			ub.setteam_ID(rs.getString(2));
			ub.setteam_name(rs.getString(3));
			ub.setleader(rs.getString(4));
			ub.setteamcol(rs.getString(5));
			ub.setteam_goal(rs.getString(6));
			
			al.add(ub);
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return al;
}

public boolean team_delete(String team_ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from team where team_ID=?");
		ps.setString(1, team_ID);
		
		
		
		int a=ps.executeUpdate();
		if(a==1)b=true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	
	return b;
}



}