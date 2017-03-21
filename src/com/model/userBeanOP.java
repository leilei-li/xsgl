package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class userBeanOP {
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

public userBean getUserInfo(String userName,String password){
	userBean ub=null;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("select * from user where username=? and password=?");
		ps.setString(1, userName);
	    ps.setString(2, password);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			ub=new userBean();
			ub.setId(rs.getLong(1));
			ub.setUserName(rs.getString(2));
			ub.setPassword(rs.getString(3));
			ub.setTrueName(rs.getString(4));
			ub.setType(rs.getString(5));
			ub.setID_num(rs.getString(6));
			ub.setre_ID(rs.getString(7));
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return ub;
}

public boolean usermodify(String username,String password){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update user set password=? where username=?");
		
		ps.setString(1, password);
		ps.setString(2, username);
		
		
		
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

public boolean creatlogin_log(String username,String login_time){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into login (name,login_time) values(?,?)");
		ps.setString(1, username);
		ps.setString(2, login_time);
		
		
		
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