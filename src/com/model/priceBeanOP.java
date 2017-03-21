package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class priceBeanOP {
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

public boolean creatprice(String name,String class_name,String type,String qi,String zhi,float price){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into price(name,class_name,type,qi,zhi,price) values(?,?,?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, class_name);
		ps.setString(3,type);
		ps.setString(4,qi);
		ps.setString(5,zhi);
		ps.setFloat(6,price);
		
		
		
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


public boolean modifyprice(String name,String class_name,String type,Float price,long ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update price set name=?,class_name=?,type=?,price=? where ID=?");
		
		ps.setString(1, name);
		ps.setString(2,class_name);
		ps.setString(3, type);
		ps.setFloat(4, price);
		ps.setLong(5, ID);
		
		
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

public boolean deleteprice(long ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from price where ID=?");
		
		ps.setLong(1, ID);
		
		
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

public ArrayList<priceBean> getprice(String name, String class_name){
	ArrayList<priceBean> al=new ArrayList<priceBean>();
	priceBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from price where name like '%"+name+"%' and class_name " +
				"like '%"+class_name+"%'  order by class_name,type,qi ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new priceBean();
			
			ub.setID(rs.getLong(1));
			ub.setname(rs.getString(2));
			ub.setclass_name(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setqi(rs.getFloat(5));
			ub.setzhi(rs.getFloat(6));
			ub.setprice(rs.getFloat(7));
			
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