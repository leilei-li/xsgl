package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class duizhangBeanOP {
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
public duizhangBean duizhang_ID_cunzai(int duizhang_ID){
	duizhangBean ub=null;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("select ID from duizhang where duizhang_ID=?");
		ps.setInt(1, duizhang_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			ub=new duizhangBean();
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

public boolean creat_duizhang(int duizhang_ID,String fapiao_ID,String date,String username,String danwei_name,String keshi_name){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into duizhang(duizhang_ID,fapiao_ID,date,username,danwei_name,keshi_name) values(?," +
				"?,?,?,?,?)");
		ps.setInt(1, duizhang_ID);
		ps.setString(2, fapiao_ID);
		ps.setString(3,date);
		ps.setString(4,username);
		ps.setString(5,danwei_name);
		ps.setString(6,keshi_name);
		
		
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
public ArrayList<duizhangBean> getduizhang_date(String start, String end){
	ArrayList<duizhangBean> al=new ArrayList<duizhangBean>();
	duizhangBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from duizhang where date between "+start+" and "+end+" ;";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new duizhangBean();
			
			ub.setID(rs.getLong(1));
			ub.setduizhang_ID(rs.getInt(2));
			ub.setfapiao_ID(rs.getString(3));
			ub.setdate(rs.getString(4));
			ub.setusername(rs.getString(5));
			
			
			
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

public ArrayList<duizhangBean> getduizhang_cus_ID(String cus_ID){
	ArrayList<duizhangBean> al=new ArrayList<duizhangBean>();
	duizhangBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select duizhang.*,customer.cus_ID,customer.cus_name,sales.sales_ID,sales.sales_name " +
				"from duizhang " +
				"inner join dingdan on duizhang.duizhang_ID=dingdan.duizhang_ID " +
				"inner join customer on (customer.cus_ID=dingdan.cus_ID and customer.cus_ID=?) " +
				"inner join sales on sales.sales_ID=dingdan.sales_ID ";
		ps=ct.prepareStatement(sql);
		ps.setString(1, cus_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new duizhangBean();
			
			ub.setID(rs.getLong(1));
			ub.setduizhang_ID(rs.getInt(2));
			ub.setfapiao_ID(rs.getString(3));
			ub.setdate(rs.getString(4));
			ub.setusername(rs.getString(5));
			ub.setkeshi_name(rs.getString(6));
			ub.setdanwei_name(rs.getString(7));
			ub.setcus_ID(rs.getString(8));
			ub.setcus_name(rs.getString(9));
			ub.setsales_ID(rs.getString(10));
			ub.setsales_name(rs.getString(11));
			
			
			
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

public ArrayList<duizhangBean> getduizhang_sales_ID(String sales_ID){
	ArrayList<duizhangBean> al=new ArrayList<duizhangBean>();
	duizhangBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select duizhang.*,customer.cus_ID,customer.cus_name,sales.sales_ID,sales.sales_name " +
				"from duizhang " +
				"inner join dingdan on duizhang.duizhang_ID=dingdan.duizhang_ID " +
				"inner join customer on (customer.cus_ID=dingdan.cus_ID ) " +
				"inner join sales on (sales.sales_ID=dingdan.sales_ID and sales.sales_ID=? )";
		ps=ct.prepareStatement(sql);
		ps.setString(1, sales_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new duizhangBean();
			
			ub.setID(rs.getLong(1));
			ub.setduizhang_ID(rs.getInt(2));
			ub.setfapiao_ID(rs.getString(3));
			ub.setdate(rs.getString(4));
			ub.setusername(rs.getString(5));
			ub.setkeshi_name(rs.getString(6));
			ub.setdanwei_name(rs.getString(7));
			ub.setcus_ID(rs.getString(8));
			ub.setcus_name(rs.getString(9));
			ub.setsales_ID(rs.getString(10));
			ub.setsales_name(rs.getString(11));
			
			
			
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


public ArrayList<duizhangBean> getduizhang_danwei_name(String danwei_name){
	ArrayList<duizhangBean> al=new ArrayList<duizhangBean>();
	duizhangBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select duizhang.*,customer.cus_ID,customer.cus_name,sales.sales_ID,sales.sales_name " +
				"from duizhang " +
				"inner join dingdan on duizhang.duizhang_ID=dingdan.duizhang_ID " +
				"inner join customer on (customer.cus_ID=dingdan.cus_ID ) " +
				"inner join sales on (sales.sales_ID=dingdan.sales_ID )" +
				"where duizhang.danwei_name=? ";
		ps=ct.prepareStatement(sql);
		ps.setString(1, danwei_name);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new duizhangBean();
			
			ub.setID(rs.getLong(1));
			ub.setduizhang_ID(rs.getInt(2));
			ub.setfapiao_ID(rs.getString(3));
			ub.setdate(rs.getString(4));
			ub.setusername(rs.getString(5));
			ub.setkeshi_name(rs.getString(6));
			ub.setdanwei_name(rs.getString(7));
			ub.setcus_ID(rs.getString(8));
			ub.setcus_name(rs.getString(9));
			ub.setsales_ID(rs.getString(10));
			ub.setsales_name(rs.getString(11));
			
			
			
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



public ArrayList<duizhangBean> getduizhang_keshi_name(String danwei_name,String keshi_name){
	ArrayList<duizhangBean> al=new ArrayList<duizhangBean>();
	duizhangBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select duizhang.*,customer.cus_ID,customer.cus_name,sales.sales_ID,sales.sales_name " +
				"from duizhang " +
				"inner join dingdan on duizhang.duizhang_ID=dingdan.duizhang_ID " +
				"inner join customer on (customer.cus_ID=dingdan.cus_ID ) " +
				"inner join sales on (sales.sales_ID=dingdan.sales_ID )" +
				"where ( duizhang.danwei_name=? and duizhang.keshi_name=? ) ";
		ps=ct.prepareStatement(sql);
		ps.setString(1, danwei_name);
		ps.setString(2, keshi_name);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new duizhangBean();
			
			ub.setID(rs.getLong(1));
			ub.setduizhang_ID(rs.getInt(2));
			ub.setfapiao_ID(rs.getString(3));
			ub.setdate(rs.getString(4));
			ub.setusername(rs.getString(5));
			ub.setkeshi_name(rs.getString(6));
			ub.setdanwei_name(rs.getString(7));
			ub.setcus_ID(rs.getString(8));
			ub.setcus_name(rs.getString(9));
			ub.setsales_ID(rs.getString(10));
			ub.setsales_name(rs.getString(11));
			
			
			
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


public ArrayList<duizhangBean> getduizhang_dingdan_ID(String dingdan_ID){
	ArrayList<duizhangBean> al=new ArrayList<duizhangBean>();
	duizhangBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select duizhang.*,customer.cus_ID,customer.cus_name,sales.sales_ID,sales.sales_name " +
				"from duizhang " +
				"inner join dingdan on (duizhang.duizhang_ID=dingdan.duizhang_ID and duizhang.duizhang_ID like '%"+dingdan_ID+"%' ) " +
				"inner join customer on (customer.cus_ID=dingdan.cus_ID ) " +
				"inner join sales on (sales.sales_ID=dingdan.sales_ID ) ";
		ps=ct.prepareStatement(sql);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new duizhangBean();
			
			ub.setID(rs.getLong(1));
			ub.setduizhang_ID(rs.getInt(2));
			ub.setfapiao_ID(rs.getString(3));
			ub.setdate(rs.getString(4));
			ub.setusername(rs.getString(5));
			ub.setkeshi_name(rs.getString(6));
			ub.setdanwei_name(rs.getString(7));
			ub.setcus_ID(rs.getString(8));
			ub.setcus_name(rs.getString(9));
			ub.setsales_ID(rs.getString(10));
			ub.setsales_name(rs.getString(11));
			
			
			
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


public boolean duizhang_delete(int duizhang_ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from duizhang where duizhang_ID=?");
		ps.setInt(1, duizhang_ID);
		
		
		
		
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