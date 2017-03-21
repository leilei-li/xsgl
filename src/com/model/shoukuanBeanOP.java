package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class shoukuanBeanOP {
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



public boolean creatshoukuan(String dingdan_ID,String fapiao_ID,String date,String sales_name,String kehu_ID,
		String jizhang,String shenhe,String type,float shishou,int shoukuan_ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into shoukuan(dingdan_ID,fapiao_ID,date,sales_name,kehu_ID," +
				"jizhang,shenhe,type,shishou,shoukuan_ID) values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, dingdan_ID);
		ps.setString(2, fapiao_ID);
		ps.setString(3,date);
		ps.setString(4,sales_name);
		ps.setString(5,kehu_ID);
		ps.setString(6,jizhang);
		ps.setString(7,shenhe);
		ps.setString(8,type);
		ps.setFloat(9,shishou);
		ps.setInt(10,shoukuan_ID);
		
		
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
public shoukuanBean fapiao_ID_cunzai(String fapiao_ID){
	shoukuanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("select * from fapiao where fapiao_ID=?");
		ps.setString(1, fapiao_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			ub=new shoukuanBean();
			
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return ub;
}


public boolean modify_shishou_to_fapiao(String fapiao_ID,Float shishou){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update fapiao " +
				"set shishou=" +
				"(CASE " +
				"when money>(shishou+?) then shishou+? " +
				"when money=(shishou+?) then shishou+? " +
				"else shishou " +
				"END), " +
				"state=" +
				"(CASE " +
				"when money=shishou then '已收全款' " +
				"else state " +
				"END) " +
				"where fapiao_ID=?");
		
		ps.setFloat(1,shishou);
		ps.setFloat(2,shishou);
		ps.setFloat(3,shishou);
		ps.setFloat(4,shishou);
		ps.setString(5, fapiao_ID);
		
		
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

public shoukuanBean shoukuan_ID_cunzai(int shoukuan_ID){
	shoukuanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("select ID from shoukuan where shoukuan_ID=?");
		ps.setInt(1, shoukuan_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			ub=new shoukuanBean();
			ub.setID(rs.getLong(1));
			
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return ub;
}

public ArrayList<shoukuanBean> getshoukuan_date(String start,String end){
	ArrayList<shoukuanBean> al=new ArrayList<shoukuanBean>();
	shoukuanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from shoukuan where date between "+start+" and  "+end+" ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new shoukuanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setfapiao_ID(rs.getString(3));
			ub.setdate(rs.getString(4));
			ub.setsales_name(rs.getString(5));
			ub.setkehu_ID(rs.getString(6));
			ub.setjizhang(rs.getString(7));
			ub.setshenhe(rs.getString(8));
			ub.settype(rs.getString(9));
			ub.setshishou(rs.getFloat(10));
			ub.setshoukuan_ID(rs.getInt(11));
			
			
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