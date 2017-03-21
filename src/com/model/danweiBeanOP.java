package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class danweiBeanOP {
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

public boolean creatdanwei(String danwei_name,String address,String info,String chair,String area_name){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into danwei(danwei_name,address,info,chair,area_name) values(?,?,?,?,?)");
		ps.setString(1, danwei_name);
		ps.setString(2, address);
		ps.setString(3, info);
		ps.setString(4, chair);
		ps.setString(5, area_name);
		
		
		
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

public keshiBean keshi_cunzai(String keshi_name,String danwei_name){
	keshiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("select ID from keshi where keshi_name=? and danwei_name=?");
		ps.setString(1, keshi_name);
		ps.setString(2, danwei_name);
		rs=ps.executeQuery();
		
		while(rs.next()){
			ub=new keshiBean();
			ub.setId(rs.getLong(1));
			
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return ub;
}



public boolean modifydanwei(String danwei_name,String address,String info,String chair,String area_name){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update danwei set address=?,info=?,chair=?,area_name=? where danwei_name=?");
		
		ps.setString(1, address);
		ps.setString(2,info);
		ps.setString(3, chair);
		ps.setString(4, area_name);
		ps.setString(5, danwei_name);
		
		
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

public boolean danwei_delete(String danwei_name){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from danwei where danwei_name=?");
		ps.setString(1, danwei_name);
		
		
		
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

public ArrayList<danweiBean> getdanwei_name(String danwei_name){
	ArrayList<danweiBean> al=new ArrayList<danweiBean>();
	danweiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from danwei where danwei_name like '%"+danwei_name+"%' order by area_name ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new danweiBean();
			
			ub.setId(rs.getLong(1));
			ub.setdanwei_name(rs.getString(2));
			ub.setaddress(rs.getString(3));
			ub.setinfo(rs.getString(4));
			ub.setchair(rs.getString(5));
			ub.setarea_name(rs.getString(6));
			
			
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

public ArrayList<danweiBean> getdanwei_name_area_name(String area_name){
	ArrayList<danweiBean> al=new ArrayList<danweiBean>();
	danweiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select danwei_name from danwei where area_name =? ";
		ps=ct.prepareStatement(sql);
		
		ps.setString(1, area_name);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new danweiBean();
			
			
			ub.setdanwei_name(rs.getString(1));
			
			
			
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

public ArrayList<danweiBean> getarea_name_city(String city){
	ArrayList<danweiBean> al=new ArrayList<danweiBean>();
	danweiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select distinct area_name from danwei where city =? ";
		ps=ct.prepareStatement(sql);
		
		ps.setString(1, city);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new danweiBean();
			
			
			ub.setarea_name(rs.getString(1));
			
			
			
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

public ArrayList<danweiBean> getarea_name_p(){
	ArrayList<danweiBean> al=new ArrayList<danweiBean>();
	danweiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select distinct area_name from danwei ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new danweiBean();
			
			
			ub.setarea_name(rs.getString(1));
			
			
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