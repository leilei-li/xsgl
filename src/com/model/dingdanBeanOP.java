package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class dingdanBeanOP {
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
	
	public boolean creatDingdan(String dingdan_ID,String date,String type,String dingdanhao,String cus_ID,String sales_ID,
			String state,String fapiao,String yangpinmiaoshu,String sample_num,float price,float sell_off,float num, String shoufei_num,
			int duizhang_ID){
		boolean b=false;
		
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("insert into dingdan(dingdan_ID,date,type,dingdanhao,cus_ID,sales_ID,state,fapiao_ID,yangpinmiaoshu," +
					"sample_num,price,sell_off,shoufei_num,num,duizhang_ID) values(?," +
					"?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, dingdan_ID);
			ps.setString(2, date);
			ps.setString(3,type);
			ps.setString(4,dingdanhao);
			ps.setString(5,cus_ID);
			ps.setString(6,sales_ID);
			ps.setString(7,state);
			ps.setString(8,fapiao);
			ps.setString(9,yangpinmiaoshu);
			ps.setString(10,sample_num);
			ps.setFloat(11,price);
			ps.setFloat(12,sell_off);
			ps.setString(13,shoufei_num);
			ps.setFloat(14, num);
			ps.setInt(15, duizhang_ID);
			
			
			
			
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
	
public boolean modifydingdan(String dingdan_ID,String date,String type,String dingdanhao,String cus_ID,String sales_ID,
			String state,String fapiao,String yangpinmiaoshu,String sample_num,float price,float sell_off,String shoufei_num){
		boolean b=false;
		
		try {
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("update dingdan set date=?,type=?,cus_ID=?,sales_ID=?,state=?,fapiao_ID=?,yangpinmiaoshu=?," +
					"sample_num=?,price=?,sell_off=?,shoufei_num=? where dingdan_ID=?");
			
			ps.setString(1, date);
			ps.setString(2,type);
			
			ps.setString(3,cus_ID);
			ps.setString(4,sales_ID);
			ps.setString(5,state);
			ps.setString(6,fapiao);
			ps.setString(7,yangpinmiaoshu);
			ps.setString(8,sample_num);
			ps.setFloat(9,price);
			ps.setFloat(10,sell_off);
			ps.setString(11,shoufei_num);
			ps.setString(12,dingdanhao);
			
			
			
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
	
	
	
	
	
public ArrayList<dingdanBean> getdingdan_dingdan_ID(String dingdan_ID){
		ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
		dingdanBean ub=null;
		
		try {
			ct=new ConnDB().getConn();

			String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
					"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
					"sample_num,price,sell_off,shoufei_num,num,cus_name," +
					"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales " +
					"where dingdan.dingdan_ID like  '%"+dingdan_ID+"%' and" +
					" dingdan.cus_ID=customer.cus_ID and dingdan.sales_ID=sales.sales_ID";
			ps=ct.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				ub=new dingdanBean();
				
				ub.setID(rs.getLong(1));
				ub.setdingdan_ID(rs.getString(2));
				ub.setdate(rs.getString(3));
				ub.settype(rs.getString(4));
				ub.setdingdanhao(rs.getString(5));
				ub.setcus_ID(rs.getString(6));
				ub.setsales_ID(rs.getString(7));
				ub.setstate(rs.getString(8));
				ub.setfapiao(rs.getString(9));
				ub.setyangpinmiaoshu(rs.getString(10));
				ub.setsample_num(rs.getString(11));
				ub.setprice(rs.getFloat(12));
				ub.setsell_off(rs.getFloat(13));
				ub.setshoufei_num(rs.getString(14));
				ub.setnum(rs.getFloat(15));
				ub.setcus_name(rs.getString(16));
				ub.setsales_name(rs.getString(17));
				ub.setkeshi_name(rs.getString(18));
				ub.setdanwei_name(rs.getString(19));
				ub.setduizhang_ID(rs.getInt(20));
				
				
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

public ArrayList<dingdanBean> getdingdan_dingdan_ID1(String dingdan_ID,String shoufei_num){
	ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
				"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
				"sample_num,price,sell_off,shoufei_num,num,cus_name," +
				"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales " +
				"where dingdan.dingdan_ID like  '%"+dingdan_ID+"%' and dingdan.shoufei_num like '%"+shoufei_num+"%'  and " +
				" dingdan.cus_ID=customer.cus_ID and dingdan.sales_ID=sales.sales_ID";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new dingdanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setdate(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setdingdanhao(rs.getString(5));
			ub.setcus_ID(rs.getString(6));
			ub.setsales_ID(rs.getString(7));
			ub.setstate(rs.getString(8));
			ub.setfapiao(rs.getString(9));
			ub.setyangpinmiaoshu(rs.getString(10));
			ub.setsample_num(rs.getString(11));
			ub.setprice(rs.getFloat(12));
			ub.setsell_off(rs.getFloat(13));
			ub.setshoufei_num(rs.getString(14));
			ub.setnum(rs.getFloat(15));
			ub.setcus_name(rs.getString(16));
			ub.setsales_name(rs.getString(17));
			ub.setkeshi_name(rs.getString(18));
			ub.setdanwei_name(rs.getString(19));
			ub.setduizhang_ID(rs.getInt(20));
			
			
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

public ArrayList<dingdanBean> getdingdan_state(String state){
	ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
				"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
				"sample_num,price,sell_off,shoufei_num,num,cus_name," +
				"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales " +
				"where dingdan.state=?  and " +
				" dingdan.cus_ID=customer.cus_ID and dingdan.sales_ID=sales.sales_ID  " +
				"order by date,danwei_name,keshi_name";
		ps=ct.prepareStatement(sql);
		
		ps.setString(1, state);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new dingdanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setdate(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setdingdanhao(rs.getString(5));
			ub.setcus_ID(rs.getString(6));
			ub.setsales_ID(rs.getString(7));
			ub.setstate(rs.getString(8));
			ub.setfapiao(rs.getString(9));
			ub.setyangpinmiaoshu(rs.getString(10));
			ub.setsample_num(rs.getString(11));
			ub.setprice(rs.getFloat(12));
			ub.setsell_off(rs.getFloat(13));
			ub.setshoufei_num(rs.getString(14));
			ub.setnum(rs.getFloat(15));
			ub.setcus_name(rs.getString(16));
			ub.setsales_name(rs.getString(17));
			ub.setkeshi_name(rs.getString(18));
			ub.setdanwei_name(rs.getString(19));
			ub.setduizhang_ID(rs.getInt(20));
			
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

public ArrayList<dingdanBean> getdingdan_duizhang_ID(String duizhang_ID){
	ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
				"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
				"sample_num,price,sell_off,shoufei_num,num,cus_name," +
				"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales " +
				"where dingdan.duizhang_ID="+duizhang_ID+"  and " +
				" dingdan.cus_ID=customer.cus_ID and dingdan.sales_ID=sales.sales_ID  " +
				"order by date,danwei_name,keshi_name";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new dingdanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setdate(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setdingdanhao(rs.getString(5));
			ub.setcus_ID(rs.getString(6));
			ub.setsales_ID(rs.getString(7));
			ub.setstate(rs.getString(8));
			ub.setfapiao(rs.getString(9));
			ub.setyangpinmiaoshu(rs.getString(10));
			ub.setsample_num(rs.getString(11));
			ub.setprice(rs.getFloat(12));
			ub.setsell_off(rs.getFloat(13));
			ub.setshoufei_num(rs.getString(14));
			ub.setnum(rs.getFloat(15));
			ub.setcus_name(rs.getString(16));
			ub.setsales_name(rs.getString(17));
			ub.setkeshi_name(rs.getString(18));
			ub.setdanwei_name(rs.getString(19));
			ub.setduizhang_ID(rs.getInt(20));
			
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

public ArrayList<dingdanBean> getdingdan_cus_ID(String cus_ID){
	ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
				"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
				"sample_num,price,sell_off,shoufei_num,num,cus_name," +
				"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales " +
				"where dingdan.cus_ID="+cus_ID+"  and " +
				"dingdan.cus_ID=customer.cus_ID and dingdan.sales_ID=sales.sales_ID  " +
				"order by date,danwei_name,keshi_name";
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new dingdanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setdate(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setdingdanhao(rs.getString(5));
			ub.setcus_ID(rs.getString(6));
			ub.setsales_ID(rs.getString(7));
			ub.setstate(rs.getString(8));
			ub.setfapiao(rs.getString(9));
			ub.setyangpinmiaoshu(rs.getString(10));
			ub.setsample_num(rs.getString(11));
			ub.setprice(rs.getFloat(12));
			ub.setsell_off(rs.getFloat(13));
			ub.setshoufei_num(rs.getString(14));
			ub.setnum(rs.getFloat(15));
			ub.setcus_name(rs.getString(16));
			ub.setsales_name(rs.getString(17));
			ub.setkeshi_name(rs.getString(18));
			ub.setdanwei_name(rs.getString(19));
			ub.setduizhang_ID(rs.getInt(20));
			
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

public ArrayList<dingdanBean> getdingdan_cus_ID_j(String cus_ID){//精确查找
	ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
				"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
				"sample_num,price,sell_off,shoufei_num,num,cus_name," +
				"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales " +
				"where dingdan.cus_ID=?  and " +
				"dingdan.cus_ID=customer.cus_ID and dingdan.sales_ID=sales.sales_ID  " +
				"order by date,danwei_name,keshi_name";
		ps=ct.prepareStatement(sql);
		ps.setString(1, cus_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new dingdanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setdate(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setdingdanhao(rs.getString(5));
			ub.setcus_ID(rs.getString(6));
			ub.setsales_ID(rs.getString(7));
			ub.setstate(rs.getString(8));
			ub.setfapiao(rs.getString(9));
			ub.setyangpinmiaoshu(rs.getString(10));
			ub.setsample_num(rs.getString(11));
			ub.setprice(rs.getFloat(12));
			ub.setsell_off(rs.getFloat(13));
			ub.setshoufei_num(rs.getString(14));
			ub.setnum(rs.getFloat(15));
			ub.setcus_name(rs.getString(16));
			ub.setsales_name(rs.getString(17));
			ub.setkeshi_name(rs.getString(18));
			ub.setdanwei_name(rs.getString(19));
			ub.setduizhang_ID(rs.getInt(20));
			
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

public ArrayList<dingdanBean> getdingdan_sales_ID(String sales_ID){
	ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
				"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
				"sample_num,price,sell_off,shoufei_num,num,cus_name," +
				"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales " +
				"where dingdan.sales_ID=?  and " +
				"dingdan.cus_ID=customer.cus_ID and dingdan.sales_ID=sales.sales_ID  " +
				"order by date,danwei_name,keshi_name";
		ps=ct.prepareStatement(sql);
		ps.setString(1, sales_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new dingdanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setdate(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setdingdanhao(rs.getString(5));
			ub.setcus_ID(rs.getString(6));
			ub.setsales_ID(rs.getString(7));
			ub.setstate(rs.getString(8));
			ub.setfapiao(rs.getString(9));
			ub.setyangpinmiaoshu(rs.getString(10));
			ub.setsample_num(rs.getString(11));
			ub.setprice(rs.getFloat(12));
			ub.setsell_off(rs.getFloat(13));
			ub.setshoufei_num(rs.getString(14));
			ub.setnum(rs.getFloat(15));
			ub.setcus_name(rs.getString(16));
			ub.setsales_name(rs.getString(17));
			ub.setkeshi_name(rs.getString(18));
			ub.setdanwei_name(rs.getString(19));
			ub.setduizhang_ID(rs.getInt(20));
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

public ArrayList<dingdanBean> getdingdan_sales_ID_j(String sales_ID){//精确查找
	ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
				"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
				"sample_num,price,sell_off,shoufei_num,num,cus_name," +
				"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales " +
				"where dingdan.sales_ID=?  and " +
				"dingdan.cus_ID=customer.cus_ID and dingdan.sales_ID=sales.sales_ID  " +
				"order by date,danwei_name,keshi_name";
		ps=ct.prepareStatement(sql);
		ps.setString(1, sales_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new dingdanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setdate(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setdingdanhao(rs.getString(5));
			ub.setcus_ID(rs.getString(6));
			ub.setsales_ID(rs.getString(7));
			ub.setstate(rs.getString(8));
			ub.setfapiao(rs.getString(9));
			ub.setyangpinmiaoshu(rs.getString(10));
			ub.setsample_num(rs.getString(11));
			ub.setprice(rs.getFloat(12));
			ub.setsell_off(rs.getFloat(13));
			ub.setshoufei_num(rs.getString(14));
			ub.setnum(rs.getFloat(15));
			ub.setcus_name(rs.getString(16));
			ub.setsales_name(rs.getString(17));
			ub.setkeshi_name(rs.getString(18));
			ub.setdanwei_name(rs.getString(19));
			ub.setduizhang_ID(rs.getInt(20));
			
			
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

public boolean dingdan_delete(String dingdan_ID){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("delete from dingdan where dingdan_ID=?");
		ps.setString(1, dingdan_ID);
		
		
		
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

public ArrayList<dingdanBean> getdingdan_between_date(String start,String end,String sales_name,String cus_name,String area_name, 
		String danwei, String keshi_name,String dingdan_ID,String shoufei_num){
	ArrayList<dingdanBean> al=new ArrayList<dingdanBean>();
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();

		String sql="select dingdan.ID,dingdan_ID,date,dingdan.type,dingdanhao,dingdan.cus_ID," +
					"dingdan.sales_ID, dingdan.state,fapiao_ID,yangpinmiaoshu," +
					"sample_num,price,sell_off,shoufei_num,num,cus_name," +
					"sales_name,keshi_name,danwei_name,duizhang_ID from dingdan,customer,sales  where (date between "+start+" and "+end+" ) and " +
							" dingdan_ID like '%"+dingdan_ID+"%' and shoufei_num like '%"+shoufei_num+"%' and " +
				"dingdan.sales_ID in (select sales_ID from sales where sales_name like '%"+sales_name+"%' ) and  " +
				"dingdan.cus_ID in (select cus_ID from customer where cus_name like '%"+cus_name+"%' and " +
						"keshi_name like '%"+keshi_name+"%' and danwei_name like '%"+danwei+"%' and area_name like '%"+area_name+"%') and " +
								"dingdan.sales_ID=sales.sales_ID and dingdan.cus_ID=customer.cus_ID;";
			
		ps=ct.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			
			ub=new dingdanBean();
			
			ub.setID(rs.getLong(1));
			ub.setdingdan_ID(rs.getString(2));
			ub.setdate(rs.getString(3));
			ub.settype(rs.getString(4));
			ub.setdingdanhao(rs.getString(5));
			ub.setcus_ID(rs.getString(6));
			ub.setsales_ID(rs.getString(7));
			ub.setstate(rs.getString(8));
			ub.setfapiao(rs.getString(9));
			ub.setyangpinmiaoshu(rs.getString(10));
			ub.setsample_num(rs.getString(11));
			ub.setprice(rs.getFloat(12));
			ub.setsell_off(rs.getFloat(13));
			ub.setshoufei_num(rs.getString(14));
			ub.setnum(rs.getFloat(15));
			ub.setcus_name(rs.getString(16));
			ub.setsales_name(rs.getString(17));
			ub.setkeshi_name(rs.getString(18));
			ub.setdanwei_name(rs.getString(19));
			ub.setduizhang_ID(rs.getInt(20));
			
			
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

public dingdanBean dingdan_ID_cunzai(String dingdan_ID){
	dingdanBean ub=null;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("select dingdanhao from dingdan where dingdan_ID=?");
		ps.setString(1, dingdan_ID);
		rs=ps.executeQuery();
		
		while(rs.next()){
			ub=new dingdanBean();
			ub.setdingdan_ID(rs.getString(1));
			
			
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		this.close();
	}
	return ub;
}
public boolean modifydingdan_state(String dingdan_ID,int duizhang_ID,String state){
	boolean b=false;
	
	try {
		ct=new ConnDB().getConn();
		ps=ct.prepareStatement("update dingdan set state=?, duizhang_ID=? where dingdan_ID=?");
		
		ps.setString(1,state);
		ps.setInt(2,duizhang_ID);
		ps.setString(3,dingdan_ID);
		
		
		
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