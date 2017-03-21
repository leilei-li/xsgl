package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.duizhangBean;
import com.model.duizhangBeanOP;

public class duizhang_search_date extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String start=request.getParameter("start");
		start=new String(start.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		String end=request.getParameter("end");
		end=new String(end.getBytes("iso-8859-1"),"utf-8");//这句话很重要，是用来转码的
		
		duizhangBeanOP tbb=new duizhangBeanOP();
		duizhangBean tb=null;
		ArrayList<duizhangBean> al=null;
	    
		
			
			al=tbb.getduizhang_date(start,end);
			if(al.size()>0){
				request.setAttribute("duizhangArray", al);
				request.getRequestDispatcher("duizhang_info_brife.jsp").forward(request, response);
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
