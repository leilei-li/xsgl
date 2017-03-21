package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.visitBean;
import com.model.visitBeanOP;

public class visit__dan_searchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String text1=request.getParameter("text");
		text1=new String(text1.getBytes("iso-8859-1"),"utf-8");
		
		visitBeanOP tbb=new visitBeanOP();
		visitBean tb=null;
		ArrayList<visitBean> al=null;
	    String type=request.getParameter("select") ;
	    type=new String(type.getBytes("iso-8859-1"),"utf-8");
		
	    //System.out.print("sb");
	    if(type.equals("时间")){
			//System.out.print("heheda");
			al=tbb.getVisit_date(text1);
			if(al.size()>0){
				
				request.setAttribute("visitArray", al);
				request.setAttribute("visitInfo", tb);
				request.getRequestDispatcher("visit_info_brife.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
			
		}
		
		else if(type.equals("员工号")){
			
			if(text1.equals("admin")){
				text1="";
			}
			al=tbb.getVisit_sale_ID(text1);
			if(al.size()>0){
				System.out.print(al.get(2).getsales_name());
				//System.out.print("nihao");
				request.setAttribute("visitArray", al);
				request.setAttribute("visitInfo", tb);
				request.getRequestDispatcher("visit_info_brife.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("no_info.jsp").forward(request, response);
			}
			
		}
		
	
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
