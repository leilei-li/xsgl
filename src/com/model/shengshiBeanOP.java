package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class shengshiBeanOP {
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

public ArrayList<shengshiBean> getshengshi_p(){
	ArrayList<shengshiBean> al=new ArrayList<shengshiBean>();
    shengshiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select distinct province,priority from shengshi order by priority desc";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new shengshiBean();
			
			
			
			ub.setprovince(rs.getString(1));
			
			
			
			
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

public ArrayList<shengshiBean> getcity_province(String province){
	ArrayList<shengshiBean> al=new ArrayList<shengshiBean>();
    shengshiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select city from shengshi where province=?";
		ps=ct.prepareStatement(sql);
		
		ps.setString(1, province);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new shengshiBean();
			
			
			
			ub.setcity(rs.getString(1));
			
			
			
			
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



}