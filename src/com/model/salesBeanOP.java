package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class salesBeanOP {
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
public ArrayList<salesBean> getSales_name(String name){
	ArrayList<salesBean> al=new ArrayList<salesBean>();
	salesBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from sales where sales_name like '%"+name+"%'  order by sales_name ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new salesBean();
			
			ub.setID(rs.getLong(1));
			ub.setsales_ID(rs.getString(2));
			ub.setname(rs.getString(3));
			ub.setsex(rs.getString(4));
			ub.setCN_ID(rs.getString(5));
			ub.setmobile1(rs.getString(6));
			ub.setmobile2(rs.getString(7));
			ub.setinDate(rs.getString(8));
			ub.setduty(rs.getString(9));
			ub.setlevel(rs.getString(10));
			ub.setsalary(rs.getFloat(11));
			ub.setroyalty(rs.getFloat(12));
			ub.setTeam_ID(rs.getString(13));
			ub.setfavorite(rs.getString(14));
			ub.setcharacter(rs.getString(15));
			ub.setemail(rs.getString(16));
			
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
public ArrayList<salesBean> getSales_mobile1(String mobile1){
	ArrayList<salesBean> al=new ArrayList<salesBean>();
	salesBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from sales where mobile1 like '%"+mobile1+"%'  order by mobile1 ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
ub=new salesBean();
			
			ub.setID(rs.getLong(1));
			ub.setsales_ID(rs.getString(2));
			ub.setname(rs.getString(3));
			ub.setsex(rs.getString(4));
			ub.setCN_ID(rs.getString(5));
			ub.setmobile1(rs.getString(6));
			ub.setmobile2(rs.getString(7));
			ub.setinDate(rs.getString(8));
			ub.setduty(rs.getString(9));
			ub.setlevel(rs.getString(10));
			ub.setsalary(rs.getFloat(11));
			ub.setroyalty(rs.getFloat(12));
			ub.setTeam_ID(rs.getString(13));
			ub.setfavorite(rs.getString(14));
			ub.setcharacter(rs.getString(15));
			ub.setemail(rs.getString(16));
			
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

public ArrayList<salesBean> getSales_sales_ID(String sales_ID){
	ArrayList<salesBean> al=new ArrayList<salesBean>();
	salesBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from sales where sales_ID like '%"+sales_ID+"%'  order by sales_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new salesBean();
			
			ub.setID(rs.getLong(1));
			ub.setsales_ID(rs.getString(2));
			ub.setname(rs.getString(3));
			ub.setsex(rs.getString(4));
			ub.setCN_ID(rs.getString(5));
			ub.setmobile1(rs.getString(6));
			ub.setmobile2(rs.getString(7));
			ub.setinDate(rs.getString(8));
			ub.setduty(rs.getString(9));
			ub.setlevel(rs.getString(10));
			ub.setsalary(rs.getFloat(11));
			ub.setroyalty(rs.getFloat(12));
			ub.setTeam_ID(rs.getString(13));
			ub.setfavorite(rs.getString(14));
			ub.setcharacter(rs.getString(15));
			ub.setemail(rs.getString(16));
			
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

public ArrayList<salesBean> getsales_duo(String sales_ID, String sales_name, String mobile1){
	ArrayList<salesBean> al=new ArrayList<salesBean>();
	salesBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from sales where sales_ID like '%"+sales_ID+"%' "
				+ "and sales_name like '%" +sales_name+ "%' "
				+ "and mobile1 like '%" +mobile1+ "%' order by sales_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new salesBean();
			
			ub.setID(rs.getLong(1));
			ub.setsales_ID(rs.getString(2));
			ub.setname(rs.getString(3));
			ub.setsex(rs.getString(4));
			ub.setCN_ID(rs.getString(5));
			ub.setmobile1(rs.getString(6));
			ub.setmobile2(rs.getString(7));
			ub.setinDate(rs.getString(8));
			ub.setduty(rs.getString(9));
			ub.setlevel(rs.getString(10));
			ub.setsalary(rs.getFloat(11));
			ub.setroyalty(rs.getFloat(12));
			ub.setTeam_ID(rs.getString(13));
			ub.setfavorite(rs.getString(14));
			ub.setcharacter(rs.getString(15));
			ub.setemail(rs.getString(16));
			
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



public boolean modifySales(String sales_ID,String name,String sex,String CN_ID,String mobile1,String mobile2,String inDate,
		String duty,String level,float salary,float royalty,String Team_ID,String email,String characte,
		String favorite){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update sales set sales_name=?,sex=?,CN_ID=?,mobile1=?,mobile2=?,inDate=?,duty=?," +
				"level=?,salary=?,royalty=?,Team_ID=?,favorite=?,characte=?,email=? where sales_ID=?");
		
		ps.setString(1, name);
		ps.setString(2,sex);
		ps.setString(3,CN_ID);
		ps.setString(4,mobile1);
		ps.setString(5,mobile2);
		ps.setString(6,inDate);
		ps.setString(7,duty);
		ps.setString(8,level);
		ps.setFloat(9,salary);
		ps.setFloat(10,royalty);
		ps.setString(11,Team_ID);
		ps.setString(12,favorite);
		ps.setString(13,characte);
		ps.setString(14,email);
		ps.setString(15,sales_ID);
		
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

public boolean sales_delete(String sales_ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from sales where sales_ID=?");
		ps.setString(1, sales_ID);
		
		
		
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

	public boolean creatSales(String sales_ID,String name,String sex,String CN_ID,String mobile1,String mobile2,String inDate,
			String duty,String level,float salary,float royalty,String Team_ID,
			String favourite,String character,String email){
		boolean b=false;
		
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("insert into sales(sales_ID,sales_name,sex,CN_ID,mobile1,mobile2,inDate,duty,level," +
					"salary,royalty,Team_ID,favorite,characte,email) values(?," +
					"?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, sales_ID);
			ps.setString(2, name);
			ps.setString(3,sex);
			ps.setString(4,CN_ID);
			ps.setString(5,mobile1);
			ps.setString(6,mobile2);
			ps.setString(7,inDate);
			ps.setString(8,duty);
			ps.setString(9,level);
			ps.setFloat(10,salary);
			ps.setFloat(11,royalty);
			ps.setString(12,Team_ID);
			ps.setString(13,favourite);
			ps.setString(14,character);
			ps.setString(15,email);
			
			
			
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

	public salesBean sales_ID_cunzai(String sales_ID){
		salesBean ub=null;
		
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select sales_name from sales where sales_ID=?");
			ps.setString(1, sales_ID);
			rs=ps.executeQuery();
			
			while(rs.next()){
				ub=new salesBean();
				ub.setname(rs.getString(1));
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		return ub;
	}
	
	
	
	
	
	
}