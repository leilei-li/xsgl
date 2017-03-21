package com.calculate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.fapiaoBean;
import com.model.fapiaoBeanOP;
import com.model.salesBean;
import com.model.salesBeanOP;
import com.model.shoukuanBean;
import com.model.shoukuanBeanOP;

public class gongzi_tongji extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String sales_ID=request.getParameter("sales_ID");
		sales_ID=new String(sales_ID.getBytes("iso-8859-1"),"utf-8");
		
		String year1=request.getParameter("year");
		year1=new String(year1.getBytes("iso-8859-1"),"utf-8");
		int year=Integer.parseInt(year1);//string转int,获得select中的年份
		
		String month1=request.getParameter("month");
		month1=new String(month1.getBytes("iso-8859-1"),"utf-8");
		int month=1;//获得月份
		int start1,end1;
		if(month1.equals("一月")){
		   month=1;
		}
		else if(month1.equals("一月")){
		   month=2;
		}
		else if(month1.equals("二月")){
			   month=2;
			}
		else if(month1.equals("三月")){
			   month=3;
			}
		else if(month1.equals("四月")){
			   month=4;
			}
		else if(month1.equals("五月")){
			   month=5;
			}
		else if(month1.equals("六月")){
			   month=6;
			}
		else if(month1.equals("七月")){
			   month=7;
			}
		else if(month1.equals("八月")){
			   month=8;
			}
		else if(month1.equals("九月")){
			   month=9;
			}
		else if(month1.equals("十月")){
			   month=10;
			}
		else if(month1.equals("十一月")){
			   month=11;
			}
		else if(month1.equals("十二月")){
			   month=12;
			}
		if(month!=12){
			    start1=year*10000+month*100+01;
				end1=year*10000+(month+1)*100+01;
		}
		else{
			    start1=year*10000+month*100+01;
				end1=(year+1)*10000+1*100+01;
		}//计算出开始和结束的时间
		String start="";
		String end="";
		start=String.valueOf(start1);
		end=String.valueOf(end1);
		
		System.out.println(start);
		System.out.println(end);
		
		shoukuanBeanOP tbb=new shoukuanBeanOP();
		shoukuanBean tb=null;
		ArrayList<shoukuanBean> al=null;
	    //System.out.print("sb");
			al=tbb.getshoukuan_date(start,end);//获得收款信息
		salesBeanOP sbb=new salesBeanOP();
		ArrayList<salesBean> sb=null;
		    sb=sbb.getSales_sales_ID(sales_ID);//获得sales信息
		float[] xiaoshou=new float[sb.size()]; //建立一个数组用来销售总额
		for(int i=0;i<sb.size();i++)
		{    
			xiaoshou[i]=0;//初始化销售总额
			for(int j=0;j<al.size();j++)
			{
				if(al.get(j).getsales_name().equals(sb.get(i).getsales_ID())){
					xiaoshou[i]=xiaoshou[i]+al.get(j).getshishou();
				}
			}
			System.out.println(xiaoshou[i]);
		}
			if(sb.size()>0){
				
				request.setAttribute("salesArray", sb);
				for(int i=0;i<sb.size();i++)
				{
				request.setAttribute("xiaoshou"+i+"", xiaoshou[i]);
				}
				request.getRequestDispatcher("gongzi_search.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
			
		
		
		
		
		
		
		
        
			
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
