package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class visitBeanOP {
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



public boolean creatVisit(String sale_ID,String customer_ID,String didian,String date,String reason,String gift,float gift_num,String result){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into visit_list(sale_ID,customer_ID,didian,date,reason,gift,gift_num,result) values(?,?,?,?,?,?,?,?)");
		ps.setString(1,sale_ID);
		ps.setString(2,customer_ID);
		ps.setString(3,didian);
		ps.setString(4,date);
		ps.setString(5,reason);
		ps.setString(6,gift);
		ps.setFloat(7,gift_num);
		ps.setString(8,result);
		
		
		
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



public ArrayList<visitBean> getVisit_date(String date){
	ArrayList<visitBean> al=new ArrayList<visitBean>();
	visitBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select visit_list.ID,sales_ID,customer_ID,didian,date,reason," +
				"gift,gift_num,result,cus_name,sales_name " +
				"from visit_list,customer,sales " +
				"where date like '%"+date+"%' and customer.cus_ID=visit_list.customer_ID" +
						" and sales.sales_ID=visit_list.sale_ID " +
						"order by date ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new visitBean();
			
			ub.setID(rs.getLong(1));
			ub.setsale_ID(rs.getString(2));
			ub.setcustomer_ID(rs.getString(3));
			ub.setdidian(rs.getString(4));
			ub.setdate(rs.getString(5));
			ub.setreason(rs.getString(6));
			ub.setgift(rs.getString(7));
			ub.setgift_num(rs.getFloat(8));
			ub.setresult(rs.getString(9));
			ub.setcus_name(rs.getString(10));
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
public ArrayList<visitBean> getvisit_ID(int ID){
	ArrayList<visitBean> al=new ArrayList<visitBean>();
	visitBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from visit_list where ID=?";
		ps=ct.prepareStatement(sql);
		ps.setInt(1,ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new visitBean();
			
			ub.setID(rs.getLong(1));
			ub.setsale_ID(rs.getString(2));
			ub.setcustomer_ID(rs.getString(3));
			ub.setdidian(rs.getString(4));
			ub.setdate(rs.getString(5));
			ub.setreason(rs.getString(6));
			ub.setgift(rs.getString(7));
			ub.setgift_num(rs.getFloat(8));
			ub.setresult(rs.getString(9));
			
			
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
public ArrayList<visitBean> getVisit_sale_ID(String sale_ID){
	ArrayList<visitBean> al=new ArrayList<visitBean>();
	visitBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select visit_list.ID,sales_ID,customer_ID,didian,date,reason," +
				"gift,gift_num,result,cus_name,sales_name " +
				"from visit_list,customer,sales " +
				"where sale_ID like '%"+sale_ID+"%' and customer.cus_ID=visit_list.customer_ID" +
						" and sales.sales_ID=visit_list.sale_ID " +
						"order by date desc";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new visitBean();
			
			ub.setID(rs.getLong(1));
			ub.setsale_ID(rs.getString(2));
			ub.setcustomer_ID(rs.getString(3));
			ub.setdidian(rs.getString(4));
			ub.setdate(rs.getString(5));
			ub.setreason(rs.getString(6));
			ub.setgift(rs.getString(7));
			ub.setgift_num(rs.getFloat(8));
			ub.setresult(rs.getString(9));
			ub.setcus_name(rs.getString(10));
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


public boolean visit_delete(String ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from visit_list where ID=?");
		ps.setString(1, ID);
		
		
		
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