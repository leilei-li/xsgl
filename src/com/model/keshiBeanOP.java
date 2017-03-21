package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class keshiBeanOP {
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

public boolean creatkeshi(String keshi_name,String boss,String danwei_name){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into keshi(keshi_name,boss,danwei_name) values(?,?,?)");
		ps.setString(1, keshi_name);
		ps.setString(2, boss);
		ps.setString(3,danwei_name);
		
		
		
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


public boolean modifyGift(String gift_name,float gift_num,float gift_value){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update gift set gift_num=?,gift_value=? where gift_name=?");
		
		ps.setFloat(1, gift_num);
		ps.setFloat(2,gift_value);
		ps.setString(3, gift_name);
		
		
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
public boolean modifykeshi(String keshi_name,String boss,String danwei_name){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update keshi set boss=?,danwei_name=? where keshi_name=?");
		
		ps.setString(1, boss);
		ps.setString(2,danwei_name);
		ps.setString(3, keshi_name);
		
		
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

public boolean keshi_delete(String keshi_name, String danwei_name){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from keshi where keshi_name=? and danwei_name=?");
		ps.setString(1, keshi_name);
		ps.setString(2, danwei_name);
		
		
		
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

public ArrayList<keshiBean> getkeshi_name(String keshi_name, String danwei_name){
	ArrayList<keshiBean> al=new ArrayList<keshiBean>();
	keshiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from keshi where keshi_name like '%"+keshi_name+"%' and danwei_name " +
				"like '%"+danwei_name+"%'  order by danwei_name ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new keshiBean();
			
			ub.setId(rs.getLong(1));
			ub.setkeshi_name(rs.getString(2));
			ub.setboss(rs.getString(3));
			ub.setdanwei_name(rs.getString(4));
			
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

public ArrayList<keshiBean> getkeshi_name_danwei_name(String danwei_name){
	ArrayList<keshiBean> al=new ArrayList<keshiBean>();
	keshiBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select keshi_name from keshi where danwei_name =? ";
		ps=ct.prepareStatement(sql);
		
		ps.setString(1, danwei_name);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new keshiBean();
			
			
			ub.setkeshi_name(rs.getString(1));
			
			
			
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