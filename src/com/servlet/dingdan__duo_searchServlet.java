package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.dingdanBean;
import com.model.dingdanBeanOP;

public class dingdan__duo_searchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String start=request.getParameter("start");
		start=new String(start.getBytes("iso-8859-1"),"utf-8");
		//System.out.println(start);
		String end=request.getParameter("end");
		end=new String(end.getBytes("iso-8859-1"),"utf-8");
		
		String sales_name=request.getParameter("sales_name");
		sales_name=new String(sales_name.getBytes("iso-8859-1"),"utf-8");
		
		String cus_name=request.getParameter("cus_name");
		cus_name=new String(cus_name.getBytes("iso-8859-1"),"utf-8");
		
		
		String danwei=request.getParameter("danwei");
		danwei=new String(danwei.getBytes("iso-8859-1"),"utf-8");
		
		String keshi=request.getParameter("keshi");
		keshi=new String(keshi.getBytes("iso-8859-1"),"utf-8");
		
		String area_name=request.getParameter("area_name");
		area_name=new String(area_name.getBytes("iso-8859-1"),"utf-8");
		
		String dingdan_ID=request.getParameter("dingdan_ID");
		dingdan_ID=new String(dingdan_ID.getBytes("iso-8859-1"),"utf-8");
		
		String shoufei_num=request.getParameter("shoufei_num");//这个sales_ID是用来看是谁操作的，是userBean里面的
		shoufei_num=new String(shoufei_num.getBytes("iso-8859-1"),"utf-8");
		
		dingdanBeanOP tbb=new dingdanBeanOP();
		dingdanBean tb=null;
		ArrayList<dingdanBean> al=null;
		float sum_yingshou=0,sum_shishou=0;
	    int i=0;
	    if(shoufei_num.equals("admin")){
	    	shoufei_num="";
	    }
		
			
			al=tbb.getdingdan_between_date(start,end,sales_name,cus_name,area_name,danwei,keshi,dingdan_ID,shoufei_num);
			if(al.size()>0){
				request.setAttribute("dingdanArray", al);
				request.getRequestDispatcher("dingdan_info_brife.jsp").forward(request, response);
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
