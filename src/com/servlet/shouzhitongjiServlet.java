package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.fapiaoBean;
import com.model.fapiaoBeanOP;

public class shouzhitongjiServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String start=request.getParameter("start");
		start=new String(start.getBytes("iso-8859-1"),"utf-8");
		
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
		
		fapiaoBeanOP tbb=new fapiaoBeanOP();
		fapiaoBean tb=null;
		ArrayList<fapiaoBean> al=null;
		float sum_yingshou=0,sum_shishou=0;
	    fapiaoBean kb;
	    int i=0;
	    
		
			
			al=tbb.getfapiao_between_date(start,end,sales_name,cus_name,area_name,danwei,keshi);
			if(al.size()>0){
				for(i=0;i<al.size();i++)
				{
					kb=al.get(i);
					sum_yingshou=kb.getmoney()+sum_yingshou;
					sum_shishou=kb.getshishou()+sum_shishou;
				}
				request.setAttribute("sum_yingshou", sum_yingshou);
				request.setAttribute("sum_shishou", sum_shishou);
				request.setAttribute("start", start);
				request.setAttribute("end", end);
				request.setAttribute("fapiaoArray", al);
				request.getRequestDispatcher("shouzhi_info_brife.jsp").forward(request, response);
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
