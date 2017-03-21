package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class fapiaoBeanOP {
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

public boolean creatFapiao(String fapiao_ID,String fapiao_num,String create_date,String dingdan_ID,Float money,
		String cus_ID,String sales_ID,Float shishou,String state,String fapiaotaitou,String user_ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("insert into fapiao(fapiao_ID,fapiao_num,create_date,dingdan_ID,money,cus_ID," +
				"sales_ID,shishou,state,fapiaotaitou,user_ID) values(?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, fapiao_ID);
		ps.setString(2, fapiao_num);
		ps.setString(3,create_date);
		ps.setString(4,dingdan_ID);
		ps.setFloat(5,money);
		ps.setString(6,cus_ID);
		ps.setString(7,sales_ID);
		ps.setFloat(8,shishou);
		ps.setString(9,state);
		ps.setString(10,fapiaotaitou);
		ps.setString(11,user_ID);
	
	
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

public boolean modifyFapiao(String fapiao_ID,String fapiao_num,String create_date,String dingdan_ID,Float money,
		String cus_ID,String sales_ID,Float shishou,String state,String fapiaotaitou,String user_ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update fapiao set create_date=?,dingdan_ID=?,money=?,cus_ID=?,sales_ID=?,shishou=?,state=?," +
				"fapiaotaitou=?,user_ID=?  where fapiao_ID=?");
		
		
		ps.setString(1,create_date);
		ps.setString(2,dingdan_ID);
		ps.setFloat(3,money);
		ps.setString(4,cus_ID);
		ps.setString(5,sales_ID);
		ps.setFloat(6,shishou);
		ps.setString(7,state);
		ps.setString(8,fapiaotaitou);
		ps.setString(9,user_ID);
		ps.setString(10, fapiao_ID);
		
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

public fapiaoBean getfapiao_ID(String fapiao_ID){
	fapiaoBean ub=null;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("select * from fapiao where fapiao_ID=? ");
		ps.setString(1, fapiao_ID);
	 
		
		rs=ps.executeQuery();
		
		while(rs.next()){
            ub=new fapiaoBean();
			
			ub.setID(rs.getLong(1));
			ub.setfapiao_ID(rs.getString(2));
			ub.setfapiao_num(rs.getString(3));
			ub.setcreate_date(rs.getString(4));
			ub.setdingdan_ID(rs.getString(5));
			ub.setmoney(rs.getFloat(6));
			ub.setcus_ID(rs.getString(7));
			ub.setsales_ID(rs.getString(8));
			ub.setshishou(rs.getFloat(9));
			ub.setstate(rs.getString(10));
			ub.setfapiaotaitou(rs.getString(11));
			ub.setuser_ID(rs.getString(12));
			
			
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return ub;
}



public ArrayList<fapiaoBean> getfapiao_fapiao_ID(String fapiao_ID){
	ArrayList<fapiaoBean> al=new ArrayList<fapiaoBean>();
	fapiaoBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from fapiao where fapiao_ID like '%"+fapiao_ID+"%'  order by fapiao_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new fapiaoBean();
			
			ub.setID(rs.getLong(1));
			ub.setfapiao_ID(rs.getString(2));
			ub.setfapiao_num(rs.getString(3));
			ub.setcreate_date(rs.getString(4));
			ub.setdingdan_ID(rs.getString(5));
			ub.setmoney(rs.getFloat(6));
			ub.setcus_ID(rs.getString(7));
			ub.setsales_ID(rs.getString(8));
			ub.setshishou(rs.getFloat(9));
			ub.setstate(rs.getString(10));
			ub.setfapiaotaitou(rs.getString(11));
			ub.setuser_ID(rs.getString(12));
			
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

public ArrayList<fapiaoBean> getfapiao_duo(String fapiao_ID,String sales_name,String cus_name,String fapiaotaitou,String user_ID){
	ArrayList<fapiaoBean> al=new ArrayList<fapiaoBean>();
	fapiaoBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select fapiao.* ,customer.cus_name,sales.sales_name "
				+ "from fapiao "
				+ "inner join customer on (customer.cus_ID=fapiao.cus_ID and customer.cus_name like '%"+cus_name+"%' ) "
				+ "inner join sales on (sales.sales_ID=fapiao.sales_ID and sales.sales_name like '%"+sales_name+"%' ) "
				+ "and fapiao_ID like '%"+fapiao_ID+"%' and fapiaotaitou like '%"+fapiaotaitou+"%' "
				+ "and user_ID like '%"+user_ID+"%' ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new fapiaoBean();
			
			ub.setID(rs.getLong(1));
			ub.setfapiao_ID(rs.getString(2));
			ub.setfapiao_num(rs.getString(3));
			ub.setcreate_date(rs.getString(4));
			ub.setdingdan_ID(rs.getString(5));
			ub.setmoney(rs.getFloat(6));
			ub.setcus_ID(rs.getString(7));
			ub.setsales_ID(rs.getString(8));
			ub.setshishou(rs.getFloat(9));
			ub.setstate(rs.getString(10));
			ub.setfapiaotaitou(rs.getString(11));
			ub.setuser_ID(rs.getString(12));
			ub.setcus_name(rs.getString(13));
			ub.setsales_name(rs.getString(14));
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


public ArrayList<fapiaoBean> getfapiao_fapiao_ID1(String fapiao_ID, String user_ID){
	ArrayList<fapiaoBean> al=new ArrayList<fapiaoBean>();
	fapiaoBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from fapiao where fapiao_ID like '%"+fapiao_ID+"%' and user_ID like '%"+user_ID+"%'" +
				"  order by fapiao_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new fapiaoBean();
			
			ub.setID(rs.getLong(1));
			ub.setfapiao_ID(rs.getString(2));
			ub.setfapiao_num(rs.getString(3));
			ub.setcreate_date(rs.getString(4));
			ub.setdingdan_ID(rs.getString(5));
			ub.setmoney(rs.getFloat(6));
			ub.setcus_ID(rs.getString(7));
			ub.setsales_ID(rs.getString(8));
			ub.setshishou(rs.getFloat(9));
			ub.setstate(rs.getString(10));
			ub.setfapiaotaitou(rs.getString(11));
			ub.setuser_ID(rs.getString(12));
			ub.setcus_name(rs.getString(13));
			ub.setsales_name(rs.getString(14));
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

public ArrayList<fapiaoBean> getfapiao_cus_ID(String cus_ID){
	ArrayList<fapiaoBean> al=new ArrayList<fapiaoBean>();
	fapiaoBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from fapiao where cus_ID like '%"+cus_ID+"%'  order by cus_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new fapiaoBean();
			
			ub.setID(rs.getLong(1));
			ub.setfapiao_ID(rs.getString(2));
			ub.setfapiao_num(rs.getString(3));
			ub.setcreate_date(rs.getString(4));
			ub.setdingdan_ID(rs.getString(5));
			ub.setmoney(rs.getFloat(6));
			ub.setcus_ID(rs.getString(7));
			ub.setsales_ID(rs.getString(8));
			ub.setshishou(rs.getFloat(9));
			ub.setstate(rs.getString(10));
			ub.setfapiaotaitou(rs.getString(11));
			ub.setuser_ID(rs.getString(12));
			
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

public ArrayList<fapiaoBean> getfapiao_sales_ID(String sales_ID){
	ArrayList<fapiaoBean> al=new ArrayList<fapiaoBean>();
	fapiaoBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from fapiao where sales_ID like '%"+sales_ID+"%'  order by sales_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new fapiaoBean();
			
			ub.setID(rs.getLong(1));
			ub.setfapiao_ID(rs.getString(2));
			ub.setfapiao_num(rs.getString(3));
			ub.setcreate_date(rs.getString(4));
			ub.setdingdan_ID(rs.getString(5));
			ub.setmoney(rs.getFloat(6));
			ub.setcus_ID(rs.getString(7));
			ub.setsales_ID(rs.getString(8));
			ub.setshishou(rs.getFloat(9));
			ub.setstate(rs.getString(10));
			ub.setfapiaotaitou(rs.getString(11));
			ub.setuser_ID(rs.getString(12));
			
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

public ArrayList<fapiaoBean> getfapiao_dingdan_ID(String dingdan_ID){
	ArrayList<fapiaoBean> al=new ArrayList<fapiaoBean>();
	fapiaoBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from fapiao where dingdan_ID like '%"+dingdan_ID+"%'  order by dingdan_ID ";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new fapiaoBean();
			
			ub.setID(rs.getLong(1));
			ub.setfapiao_ID(rs.getString(2));
			ub.setfapiao_num(rs.getString(3));
			ub.setcreate_date(rs.getString(4));
			ub.setdingdan_ID(rs.getString(5));
			ub.setmoney(rs.getFloat(6));
			ub.setcus_ID(rs.getString(7));
			ub.setsales_ID(rs.getString(8));
			ub.setshishou(rs.getFloat(9));
			ub.setstate(rs.getString(10));
			ub.setfapiaotaitou(rs.getString(11));
			ub.setuser_ID(rs.getString(12));
			
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

public ArrayList<fapiaoBean> getfapiao_between_date(String start,String end,String sales_name,String cus_name,String area_name, String danwei, String keshi_name){
	ArrayList<fapiaoBean> al=new ArrayList<fapiaoBean>();
	fapiaoBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select * from fapiao where (create_date between "+start+" and "+end+ " )and " +
				"sales_ID in (select sales_ID from sales where sales_name like '%"+sales_name+"%' ) and  " +
				"cus_ID in (select cus_ID from customer where cus_name like '%"+cus_name+"%' and keshi_name like '%"+keshi_name+"%' and danwei_name like '%"+danwei+"%' and area_name like '%"+area_name+"%')";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new fapiaoBean();
			
			ub.setID(rs.getLong(1));
			ub.setfapiao_ID(rs.getString(2));
			ub.setfapiao_num(rs.getString(3));
			ub.setcreate_date(rs.getString(4));
			ub.setdingdan_ID(rs.getString(5));
			ub.setmoney(rs.getFloat(6));
			ub.setcus_ID(rs.getString(7));
			ub.setsales_ID(rs.getString(8));
			ub.setshishou(rs.getFloat(9));
			ub.setstate(rs.getString(10));
			ub.setfapiaotaitou(rs.getString(11));
			ub.setuser_ID(rs.getString(12));
			
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

public boolean fapiao_delete(String fapiao_ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from fapiao where fapiao_ID=?");
		ps.setString(1, fapiao_ID);
		
		
		
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