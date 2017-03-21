package com.model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

public class giftBeanOP {
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

public boolean creatGift(String gift_name,float gift_num,float gift_value,float jifen){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into gift(gift_name,gift_num,gift_value,jifen) values(?,?,?,?)");
		ps.setString(1, gift_name);
		ps.setFloat(2, gift_num);
		ps.setFloat(3,gift_value);
		ps.setFloat(4,jifen);
		
		
		
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
public boolean modifyGift(String gift_name,float gift_num,float gift_value,float jifen){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update gift set gift_num=?,gift_value=?,jifen=? where gift_name=?");
		
		ps.setFloat(1, gift_num);
		ps.setFloat(2,gift_value);
		ps.setFloat(3,jifen);
		ps.setString(4, gift_name);
		
		
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

public boolean gift_numModify(String gift_name,float gift_num){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update gift set gift_num=gift_num+? where gift_name=? ");
		
		ps.setFloat(1, gift_num);
		ps.setString(2,gift_name);
		
		
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


public boolean gift_delete(String gift_name){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from gift where gift_name=?");
		ps.setString(1, gift_name);
		
		
		
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

public ArrayList<giftBean> getGift_gift_name(String gift_name){
	ArrayList<giftBean> al=new ArrayList<giftBean>();
	giftBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from gift where gift_name like '%"+gift_name+"%'  order by gift_name ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new giftBean();
			
			ub.setgift_ID(rs.getLong(1));
			ub.setgift_name(rs.getString(2));
			ub.setgift_num(rs.getFloat(3));
			ub.setgift_value(rs.getFloat(4));
			ub.setjifen(rs.getFloat(5));
			
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